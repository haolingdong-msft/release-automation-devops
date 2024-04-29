package io.weidongxu.util.releaseautomation;

import com.azure.core.credential.BasicAuthenticationCredential;
import com.azure.core.credential.TokenCredential;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.dev.DevManager;
import com.azure.dev.models.Pipeline;
import com.azure.dev.models.Run;
import com.azure.dev.models.RunPipelineParameters;
import com.azure.dev.models.RunState;
import com.azure.dev.models.Timeline;
import com.azure.dev.models.TimelineRecord;
import com.azure.dev.models.TimelineRecordState;
import com.azure.dev.models.Variable;
import com.spotify.github.v3.clients.GitHubClient;
import com.spotify.github.v3.clients.IssueClient;
import com.spotify.github.v3.clients.PullRequestClient;
import com.spotify.github.v3.clients.RepositoryClient;
import com.spotify.github.v3.comment.Comment;
import com.spotify.github.v3.prs.ImmutableMergeParameters;
import com.spotify.github.v3.prs.ImmutableReviewParameters;
import com.spotify.github.v3.prs.MergeMethod;
import com.spotify.github.v3.prs.PullRequest;
import com.spotify.github.v3.prs.PullRequestItem;
import com.spotify.github.v3.prs.Review;
import com.spotify.github.v3.prs.requests.ImmutablePullRequestParameters;
import com.spotify.github.v3.prs.requests.PullRequestParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LiteRelease {

    private static final Logger LOGGER = LoggerFactory.getLogger(LiteRelease.class);

    private static final String USER = Configuration.getGlobalConfiguration().get("DEVOPS_USER");
    private static final String PASS = Configuration.getGlobalConfiguration().get("DEVOPS_PAT");
    private static final String ORGANIZATION = "azure-sdk";
    private static final String PROJECT_INTERNAL = "internal";
    private static final String PROJECT_PUBLIC = "public";

    private static final String GITHUB_TOKEN = Configuration.getGlobalConfiguration().get("GITHUB_PAT");
    private static final String GITHUB_ORGANIZATION = "Azure";
    private static final String GITHUB_PROJECT = "azure-sdk-for-java";

    private static final int LITE_CODEGEN_PIPELINE_ID = 2238;

    private static final String CI_CHECK_ENFORCER_NAME = "https://aka.ms/azsdk/checkenforcer";
    private static final String CI_PREPARE_PIPELINES_NAME = "prepare-pipelines";

    private static final String API_SPECS_YAML_PATH = "https://raw.githubusercontent.com/Azure/azure-sdk-for-java/main/eng/mgmt/automation/api-specs.yaml";

    private static final String MAVEN_ARTIFACT_PATH_PREFIX = "https://central.sonatype.com/artifact/com.azure.resourcemanager/";

    private static final InputStream IN = System.in;
    private static final PrintStream OUT = System.out;

    private static final boolean PROMPT_CONFIRMATION = true;
    private static final boolean PREFER_STABLE_TAG = false;

    private static final PullRequestParameters PR_LIST_PARAMS = ImmutablePullRequestParameters.builder()
            .state("open").page(1).per_page(10).build();
    private static final long POLL_SHORT_INTERVAL_MINUTE = 1;
    private static final long POLL_LONG_INTERVAL_MINUTE = 5;
    private static final long MILLISECOND_PER_MINUTE = 60 * 1000;

    public static void main(String[] args) throws Exception {
        TokenCredential tokenCredential = new BasicAuthenticationCredential(USER, PASS);

        Configure configure = getConfigure();
        String swagger = configure.getSwagger();
        String sdk = getSdkName(swagger);
        if (!CoreUtils.isNullOrEmpty(configure.getService())) {
            sdk = configure.getService();
        }

        OUT.println("swagger: " + swagger);
        OUT.println("sdk: " + sdk);

        String tag = configure.getTag();
        if (CoreUtils.isNullOrEmpty(tag)) {
            ReadmeConfigure readmeConfigure = Utils.getReadmeConfigure(HTTP_PIPELINE, swagger);
            readmeConfigure.print(OUT, 3);

            tag = readmeConfigure.getDefaultTag();
            if (tag == null) {
                tag = readmeConfigure.getTagConfigures().iterator().next().getTagName();
            }
            if (PREFER_STABLE_TAG) {
                if (tag.endsWith("-preview")) {
                    Optional<String> stableTag = readmeConfigure.getTagConfigures().stream()
                            .map(ReadmeConfigure.TagConfigure::getTagName)
                            .filter(name -> !name.endsWith("-preview"))
                            .findFirst();
                    if (stableTag.isPresent()) {
                        tag = stableTag.get();
                    }
                }
            }
            OUT.println("choose tag: " + tag + ". Override?");
            Scanner s = new Scanner(IN);
            String input = s.nextLine();
            if (!input.trim().isEmpty()) {
                tag = input.trim();
            }
        }
        OUT.println("tag: " + tag);

        if (configure.isAutoVersioning() && !tag.contains("-preview")) {
            ReadmeConfigure readmeConfigure = Utils.getReadmeConfigure(HTTP_PIPELINE, swagger);
            final String tagToRelease = tag;
            Optional<ReadmeConfigure.TagConfigure> tagConfigure = readmeConfigure.getTagConfigures().stream()
                    .filter(t -> Objects.equals(tagToRelease, t.getTagName()))
                    .findFirst();
            boolean previewInputFileInTag = tagConfigure.isPresent()
                    && tagConfigure.get().getInputFiles().stream().anyMatch(f -> f.contains("/preview/"));

            if (!previewInputFileInTag) {
                // if stable is released, and current tag is also stable
                VersionConfigure.parseVersion(HTTP_PIPELINE, sdk).ifPresent(sdkVersion -> {
                    if (sdkVersion.isStableReleased()) {
                        configure.setAutoVersioning(false);
                        configure.setVersion(sdkVersion.getCurrentVersionAsStable());

                        OUT.println("release for stable: " + configure.getVersion());
                    }
                });
            }
        }

        DevManager manager = DevManager.configure()
                .withLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.NONE))
                .withPolicy(new BasicAuthAuthenticationPolicy(tokenCredential))
//                .withPolicy(new HttpDebugLoggingPolicy())
                .authenticate(
                        new BasicAuthenticationCredential(USER, PASS),
                        new AzureProfile(AzureEnvironment.AZURE));

        GitHubClient github = GitHubClient.create(new URI("https://api.github.com/"), GITHUB_TOKEN);
        RepositoryClient client = github.createRepositoryClient(GITHUB_ORGANIZATION, GITHUB_PROJECT);

        Map<String, Variable> variables = new HashMap<>();
        variables.put("README", new Variable().withValue(swagger));
        variables.put("TAG", new Variable().withValue(tag));
//        variables.put("DRAFT_PULL_REQUEST", new Variable().withValue("false"));
        if (!configure.isAutoVersioning()) {
            variables.put("VERSION", new Variable().withValue(configure.getVersion()));
        }
        if (!CoreUtils.isNullOrEmpty(configure.getService())) {
            variables.put("SERVICE", new Variable().withValue(configure.getService()));
        }
        if (!CoreUtils.isNullOrEmpty(configure.getSuffix())) {
            variables.put("SUFFIX", new Variable().withValue(configure.getSuffix()));
        }
        if (configure.getTests() == Boolean.TRUE) {
            variables.put("AUTOREST_OPTIONS", new Variable().withValue("--generate-tests"));
        }

        runLiteCodegen(manager, variables);
        OUT.println("wait 1 minutes");
        Thread.sleep(POLL_SHORT_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);

        mergeGithubPR(client, manager, swagger, sdk);

        runLiteRelease(manager, sdk);

        mergeGithubVersionPR(client, sdk);

        String sdkMavenUrl = MAVEN_ARTIFACT_PATH_PREFIX + "azure-resourcemanager-" + sdk + "/1.0.0-beta.1/versions";
        Utils.openUrl(sdkMavenUrl);

        System.exit(0);
    }

    private static void runLiteCodegen(DevManager manager, Map<String, Variable> variables) throws InterruptedException {
        // run pipeline
        Run run = manager.runs().runPipeline(ORGANIZATION, PROJECT_INTERNAL, LITE_CODEGEN_PIPELINE_ID,
                new RunPipelineParameters().withVariables(variables));
        int buildId = run.id();

        // wait for complete
        while (run.state() != RunState.COMPLETED && run.state() != RunState.CANCELING) {
            OUT.println("build id: " + buildId + ", state: " + run.state());

            OUT.println("wait 1 minutes");
            Thread.sleep(POLL_SHORT_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);

            run = manager.runs().get(ORGANIZATION, PROJECT_INTERNAL, LITE_CODEGEN_PIPELINE_ID, buildId);
        }
    }

    private static void mergeGithubPR(RepositoryClient client, DevManager manager, String swagger, String sdk) throws InterruptedException, ExecutionException {
        PullRequestClient prClient = client.createPullRequestClient();
        List<PullRequestItem> prs = prClient.list(PR_LIST_PARAMS).get();

        PullRequestItem pr = prs.stream()
                .filter(p -> p.title().startsWith("[Automation] Generate Fluent Lite from") && p.title().contains(swagger))
                .findFirst().orElse(null);

        if (pr != null) {
            int prNumber = pr.number();

            String prUrl = "https://github.com/Azure/azure-sdk-for-java/pull/" + prNumber + "/files";
            OUT.println("GitHub pull request: " + prUrl);
            Utils.openUrl(prUrl);

            // wait for CI
            waitForChecks(client, prClient, manager, prNumber, sdk);

            if (PROMPT_CONFIRMATION) {
                Utils.promptMessageAndWait(IN, OUT,
                        "'Yes' to approve and merge GitHub pull request: https://github.com/Azure/azure-sdk-for-java/pull/" + prNumber);
            }

            // make PR ready
            Utils.prReady(HTTP_PIPELINE, GITHUB_TOKEN, prNumber);
            Thread.sleep(POLL_SHORT_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);

            // approve PR
            Review review = prClient.createReview(prNumber,
                    ImmutableReviewParameters.builder().event("APPROVE").build()).get();

            // merge PR
            PullRequest prRefreshed = prClient.get(prNumber).get();
            prClient.merge(prNumber,
                    ImmutableMergeParameters.builder().sha(prRefreshed.head().sha()).mergeMethod(MergeMethod.squash).build()).get();
            OUT.println("Pull request merged: " + prNumber);
        } else {
            throw new IllegalStateException("github pull request not found");
        }
    }

    private static void runLiteRelease(DevManager manager, String sdk) throws InterruptedException {
        List<String> releaseTemplateParameters = getReleaseTemplateParameters(manager, GITHUB_ORGANIZATION, GITHUB_PROJECT, sdk);
        if (releaseTemplateParameters.isEmpty()) {
            LOGGER.warn("release parameters not found in ci.yml");
        }

        // find pipeline
        Pipeline pipeline = findSdkPipeline(manager, sdk, false);

        if (pipeline != null) {
            Map<String, String> templateParameters = new HashMap<>();
            for (String releaseTemplateParameter : releaseTemplateParameters) {
                templateParameters.put(releaseTemplateParameter,
                        String.valueOf(releaseTemplateParameter.startsWith("release_azureresourcemanager")));
            }

            // run pipeline
            Run run = manager.runs().runPipeline(ORGANIZATION, PROJECT_INTERNAL, pipeline.id(),
                    new RunPipelineParameters().withTemplateParameters(templateParameters));
            int buildId = run.id();

            String buildUrl = "https://dev.azure.com/azure-sdk/internal/_build/results?buildId=" + buildId;
            OUT.println("DevOps build: " + buildUrl);
            Utils.openUrl(buildUrl);

            OUT.println("wait 5 minutes");
            Thread.sleep(POLL_LONG_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);
            // poll until approval is available
            ReleaseState state = null;
            while (state == null || state.getApprovalIds().isEmpty()) {
                OUT.println("wait 5 minutes");
                Thread.sleep(POLL_LONG_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);

                Timeline timeline = manager.timelines().get(ORGANIZATION, PROJECT_INTERNAL, buildId, null);
                state = getReleaseState(timeline);
            }

            if (PROMPT_CONFIRMATION) {
                Utils.promptMessageAndWait(IN, OUT,
                        "'Yes' to approve release: " + state.getName());
            }

            // approve new release
            OUT.println("prepare to release: " + state.getName());
            Utils.approve(state.getApprovalIds(), manager, ORGANIZATION, PROJECT_INTERNAL);
            OUT.println("approved release: " + state.getName());

            // poll until release completion
            while (state.getState() != TimelineRecordState.COMPLETED) {
                OUT.println("wait 5 minutes");
                Thread.sleep(POLL_LONG_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);

                Timeline timeline = manager.timelines().get(ORGANIZATION, PROJECT_INTERNAL, buildId, null);
                state = getReleaseState(timeline);
            }
        } else {
            throw new IllegalStateException("release pipeline not found for sdk: " + sdk);
        }
    }

    private static void mergeGithubVersionPR(RepositoryClient client, String sdk) throws InterruptedException, ExecutionException {
        PullRequestClient prClient = client.createPullRequestClient();
        List<PullRequestItem> prs = prClient.list(PR_LIST_PARAMS).get();

        PullRequestItem pr = prs.stream()
                .filter(p -> p.title().equals("Increment versions for " + sdk + " releases")
                        || p.title().equals("Increment version for " + sdk + " releases"))
                .findFirst().orElse(null);

        if (pr != null) {
            int prNumber = pr.number();

            // approve PR
            Review review = prClient.createReview(pr.number(),
                    ImmutableReviewParameters.builder().event("APPROVE").build()).get();

            String prUrl = "https://github.com/Azure/azure-sdk-for-java/pull/" + prNumber;
            OUT.println("GitHub pull request: " + prUrl);
            Utils.openUrl(prUrl);

            // wait for check enforcer
            waitForCommitSuccess(prClient, prNumber);

            PullRequest prRefreshed = prClient.get(prNumber).get();
            if (Boolean.TRUE.equals(prRefreshed.merged())) {
                OUT.println("Pull request auto merged: " + prNumber);
            } else {
                // merge PR
                prClient.merge(prNumber,
                        ImmutableMergeParameters.builder().sha(prRefreshed.head().sha()).mergeMethod(MergeMethod.squash).build()).get();
                OUT.println("Pull request merged: " + prNumber);
            }
        } else {
            throw new IllegalStateException("github pull request not found");
        }
    }

    private static ReleaseState getReleaseState(Timeline timeline) {
        List<ReleaseState> states = new ArrayList<>();
        for (TimelineRecord record : timeline.records()) {
            if ("Releasing: 1 libraries".equals(record.name()) && "stage1".equals(record.identifier())
                    || record.name().startsWith("Release: azure-resourcemanager-")) {
                states.add(Utils.getReleaseState(record, timeline));
            }
        }

        if (states.size() == 1) {
            ReleaseState state = states.iterator().next();
            OUT.println("release: " + state.getName() + ", state: " + state.getState());
            return state;
        } else {
            throw new IllegalStateException("release candidate not correct");
        }
    }

    private static final HttpPipeline HTTP_PIPELINE = new HttpPipelineBuilder().build();

    private static CheckRun getCheck(List<CheckRun> checkRuns, String name) {
        return checkRuns.stream()
                .filter(p -> p.getName().equals(name))
                .findAny().orElse(null);
    }

    private static void waitForChecks(RepositoryClient client, PullRequestClient prClient, DevManager manager,
                                      int prNumber, String sdk) throws InterruptedException, ExecutionException {
        // wait a bit
        OUT.println("wait 1 minutes");
        Thread.sleep(POLL_SHORT_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);

        Pipeline pipeline = findSdkPipeline(manager, sdk, true);
        String javaSdkCheckName = pipeline != null ? pipeline.name() : ("java - " + sdk + " - ci");

        boolean ciPipelineReady = pipeline != null;

        if (!ciPipelineReady) {
            LOGGER.info("prepare pipeline");

            IssueClient issueClient = client.createIssueClient();

            // comment to create sdk CI
            Comment comment = issueClient.createComment(prNumber, "/azp run prepare-pipelines").get();

            // wait for prepare pipelines
            PullRequest pr = prClient.get(prNumber).get();
            waitForCheckSuccess(prClient, prNumber, CI_PREPARE_PIPELINES_NAME, pr.head().sha());

            // comment to run the newly created sdk CI
            comment = issueClient.createComment(prNumber, "/azp run " + javaSdkCheckName).get();
        } else {
            // trigger live tests, if available
            String testPipelineName = "java - " + sdk + " - mgmt - tests";
            boolean testPipelineAvailable = manager.pipelines().list(ORGANIZATION, PROJECT_INTERNAL).stream()
                    .anyMatch(p -> p.name().equals(testPipelineName));
            if (testPipelineAvailable) {
                IssueClient issueClient = client.createIssueClient();
                // comment to trigger tests.mgmt
                Comment comment = issueClient.createComment(prNumber, "/azp run " + testPipelineName).get();
            }
        }

        // wait for sdk CI
        waitForCheckSuccess(prClient, prNumber, javaSdkCheckName);

        // wait for check enforcer
        waitForCommitSuccess(prClient, prNumber);
    }

    private static CommitStatus getCommitStatusForCheckEnforcer(String sha) {
        return Arrays.stream(Utils.getCommitStatuses(HTTP_PIPELINE, GITHUB_TOKEN, sha))
                .filter(s -> CI_CHECK_ENFORCER_NAME.equals(s.getContext()))
                .findFirst().orElse(null);
    }

    private static void waitForCommitSuccess(PullRequestClient prClient, int prNumber) throws ExecutionException, InterruptedException {
        PullRequest pr = prClient.get(prNumber).get();
        String commitSHA = pr.head().sha();

        CommitStatus status = getCommitStatusForCheckEnforcer(commitSHA);
        while (status == null || !"success".equals(status.getState())) {
            if (status == null) {
                OUT.println("pr number: " + prNumber + ", wait for " + CI_CHECK_ENFORCER_NAME);
            } else {
                OUT.println("pr number: " + prNumber + ", " + CI_CHECK_ENFORCER_NAME + " state: " + status.getState());
            }

            OUT.println("wait 1 minutes");
            Thread.sleep(POLL_SHORT_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);

            // refresh head commit
            pr = prClient.get(prNumber).get();
            commitSHA = pr.head().sha();
            status = getCommitStatusForCheckEnforcer(commitSHA);
        }
    }

    private static void waitForCheckSuccess(PullRequestClient prClient,
                                            int prNumber, String checkName) throws InterruptedException, ExecutionException {
        waitForCheckSuccess(prClient, prNumber, checkName, null);
    }

    private static void waitForCheckSuccess(PullRequestClient prClient,
                                            int prNumber, String checkName, String fixedCommitSHA) throws InterruptedException, ExecutionException {
        String commitSHA = fixedCommitSHA;
        if (commitSHA == null) {
            // refresh head commit
            PullRequest pr = prClient.get(prNumber).get();
            commitSHA = pr.head().sha();
        }
        CheckRunListResult checkRunResult = Utils.getCheckRuns(HTTP_PIPELINE, GITHUB_TOKEN, commitSHA);
        CheckRun check = getCheck(checkRunResult.getCheckRuns(), checkName);
        while (check == null || !"success".equals(check.getConclusion())) {
            if (check == null) {
                OUT.println("pr number: " + prNumber + ", wait for " + checkName);
            } else {
                OUT.println("pr number: " + prNumber + ", " + checkName + " status: " + check.getStatus() + ", conclusion: " + check.getConclusion());
            }

            OUT.println("wait 1 minutes");
            Thread.sleep(POLL_SHORT_INTERVAL_MINUTE * MILLISECOND_PER_MINUTE);

            if (fixedCommitSHA == null) {
                // refresh head commit
                PullRequest pr = prClient.get(prNumber).get();
                commitSHA = pr.head().sha();
            }
            checkRunResult = Utils.getCheckRuns(HTTP_PIPELINE, GITHUB_TOKEN, commitSHA);
            check = getCheck(checkRunResult.getCheckRuns(), checkName);
        }
    }

    private static String getSdkName(String swaggerName) {
        Matcher matcher = Pattern.compile("specification/([^/]+)/resource-manager(/.*)*/readme.md")
                .matcher(swaggerName);
        if (matcher.matches()) {
            swaggerName = matcher.group(1);
            String subspec = matcher.group(2);
            if (!CoreUtils.isNullOrEmpty(subspec)) {
                swaggerName += subspec;
            }
        }

        HttpRequest request = new HttpRequest(HttpMethod.GET, API_SPECS_YAML_PATH);
        HttpResponse response = HTTP_PIPELINE.send(request).block();
        if (response.getStatusCode() == 200) {
            String configYaml = response.getBodyAsString().block();
            response.close();

            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(configYaml);

            String sdkName = swaggerName;
            if (config.containsKey(swaggerName)) {
                Map<String, String> detail = (Map<String, String>) config.get(swaggerName);
                if (detail.containsKey("service")) {
                    sdkName = detail.get("service");
                }
            }

            sdkName = sdkName.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9_]", "");

            return sdkName;
        } else {
            response.close();
            throw new HttpResponseException(response);
        }
    }

    private static Configure getConfigure() throws IOException {
        Configure configure = null;
        Yaml yaml = new Yaml();
        Path configInPath = Paths.get("configure.yml");
        if (Files.exists(configInPath)) {
            try (InputStream in = new FileInputStream(configInPath.toFile())) {
                configure = yaml.loadAs(in, Configure.class);
            }
        }
        if (configure == null) {
            try (InputStream in = LiteRelease.class.getResourceAsStream("/configure.yml")) {
                configure = yaml.loadAs(in, Configure.class);
            }
        }
        return configure;
    }


    private static List<String> getReleaseTemplateParameters(DevManager manager,
                                                             String organization, String project, String sdk) {
        List<String> releaseTemplateParameters;

        String ciUrl = String.format("https://raw.githubusercontent.com/%1$s/%2$s/main/sdk/%3$s/azure-resourcemanager-%3$s/ci.yml",
                organization, project, sdk);
        releaseTemplateParameters = getReleaseTemplateParameters(manager, ciUrl);
        if (releaseTemplateParameters == null) {
            ciUrl = String.format("https://raw.githubusercontent.com/%1$s/%2$s/main/sdk/%3$s/ci.yml",
                    organization, project, sdk);
            releaseTemplateParameters = getReleaseTemplateParameters(manager, ciUrl);
        }

        if (releaseTemplateParameters == null) {
            throw new IllegalStateException("failed to get ci.yml: " + ciUrl);
        }

        return releaseTemplateParameters;
    }

    private static List<String> getReleaseTemplateParameters(DevManager manager, String url) {
        List<String> releaseTemplateParameters = new ArrayList<>();

        String ciUrl = String.format(url);

        HttpRequest request = new HttpRequest(HttpMethod.GET, ciUrl);
        HttpResponse response = manager.serviceClient().getHttpPipeline().send(request).block();
        System.out.println("response status code: " + response.getStatusCode());
        if (response.getStatusCode() != 200) {
            System.out.println("response body: " + response.getBodyAsString().block());
            response.close();
            return null;
        } else {
            String ciYml = response.getBodyAsString().block();
            Yaml yaml = new Yaml();
            Map<String, Object> ci = yaml.load(ciYml);
            if (ci.containsKey("parameters") && ci.get("parameters") instanceof List) {
                List<Object> parameters = (List<Object>) ci.get("parameters");
                for (Object parameterObj : parameters) {
                    if (parameterObj instanceof Map) {
                        Map<String, Object> parameter = (Map<String, Object>) parameterObj;
                        if (parameter.containsKey("name") && parameter.get("name") instanceof String) {
                            String parameterName = (String) parameter.get("name");
                            if (parameterName.startsWith("release_")) {
                                releaseTemplateParameters.add(parameterName);
                            }
                        }
                    }
                }
            }
            response.close();
        }

        return releaseTemplateParameters;
    }

    private static Pipeline findSdkPipeline(DevManager manager, String sdk, boolean publicPipeline) {
        List<Pipeline> pipelines = manager.pipelines().list(ORGANIZATION, publicPipeline ? PROJECT_PUBLIC : PROJECT_INTERNAL)
                .stream().collect(Collectors.toList());

        // find pipeline
        String pipelineName = "java - azure-resourcemanager-" + sdk + (publicPipeline ? " - ci" : "");
        final String pipelineName1 = pipelineName;
        Pipeline pipeline = pipelines.stream()
                .filter(p -> pipelineName1.equals(p.name())).findFirst().orElse(null);

        if (pipeline == null) {
            pipelineName = "java - " + sdk + (publicPipeline ? " - ci" : "");
            final String pipelineName2 = pipelineName;
            pipeline = pipelines.stream()
                    .filter(p -> pipelineName2.equals(p.name())).findFirst().orElse(null);
        }

        return pipeline;
    }
}
