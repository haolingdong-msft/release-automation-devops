package io.weidongxu.util.releaseautomation;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.azure.core.util.serializer.TypeReference;
import com.azure.dev.DevManager;
import com.azure.dev.models.Timeline;
import com.azure.dev.models.TimelineRecord;
import com.azure.dev.models.TimelineRecordState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class Utils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    private static final SerializerAdapter SERIALIZER_ADAPTER = JacksonAdapter.createDefaultSerializerAdapter();

    public static ReleaseState getReleaseState(TimelineRecord record, Timeline timeline) {
        ReleaseState state = new ReleaseState();
        state.setName(record.name().substring("Release: ".length()));
        state.setIdentifier(record.identifier());
        state.setState(record.state());
        state.setResult(record.result());

        if (state.getState() == TimelineRecordState.PENDING) {
            UUID id = record.id();

            TimelineRecord checkpointRecord = timeline.records().stream()
                    .filter(r -> id.equals(r.parentId()) && r.name().equals("Checkpoint") && r.type().equals("Checkpoint"))
                    .findAny().orElse(null);
            if (checkpointRecord != null) {
                UUID checkpointId = checkpointRecord.id();
                List<TimelineRecord> checkpointApprovalRecords = timeline.records().stream()
                        .filter(r -> checkpointId.equals(r.parentId()) && r.name().equals("Checkpoint.Approval") && r.type().equals("Checkpoint.Approval"))
                        .filter(r -> r.state() == TimelineRecordState.IN_PROGRESS)
                        .collect(Collectors.toList());

                state.getApprovalIds().addAll(checkpointApprovalRecords.stream().map(TimelineRecord::id).collect(Collectors.toList()));
            }
        }

        return state;
    }

    public static void approve(List<UUID> approvalIds, DevManager manager, String organization, String project) {
        for (UUID approvalId : approvalIds) {
            HttpRequest request = new HttpRequest(
                    HttpMethod.PATCH,
                    String.format("https://dev.azure.com/%s/%s/_apis/pipelines/approvals/%s?api-version=7.2-preview", organization, project, approvalId.toString()));
            request.setBody(String.format("[{\"approvalId\": \"%s\", \"status\": 4, \"comment\": \"\"}]", approvalId));
            request.setHeader(HttpHeaderName.CONTENT_TYPE, "application/json");
            HttpResponse response = manager.serviceClient().getHttpPipeline().send(request).block();
            System.out.println("response status code: " + response.getStatusCode());
            if (response.getStatusCode() == 200) {
                response.close();
            } else {
                System.out.println("response body: " + response.getBodyAsString().block());
                response.close();

                throw new IllegalStateException("failed to approve: " + approvalId);
            }
        }
    }


    public static CheckRunListResult getCheckRuns(HttpPipeline httpPipeline, String token, String sha) {
        HttpRequest request = new HttpRequest(HttpMethod.GET,
                "https://api.github.com/repos/Azure/azure-sdk-for-java/commits/" + sha + "/check-runs");
        request.setHeader(HttpHeaderName.AUTHORIZATION, "token " + token)
                .setHeader(HttpHeaderName.ACCEPT, "application/json")
                .setHeader(HttpHeaderName.CONTENT_TYPE, "application/json");

        HttpResponse response = httpPipeline.send(request).block();

        if (response.getStatusCode() == 200) {
            String body = response.getBodyAsString().block();
            try {
                return SERIALIZER_ADAPTER.deserialize(body, CheckRunListResult.class, SerializerEncoding.JSON);
            } catch (IOException e) {
                LOGGER.error("error in response body {}", body);
                throw new HttpResponseException(response);
            } finally {
                response.close();
            }
        } else {
            LOGGER.error("error in response code {}, body {}", response.getStatusCode(), response.getBodyAsString().block());
            response.close();
            throw new HttpResponseException(response);
        }
    }

    public static CommitStatus[] getCommitStatuses(HttpPipeline httpPipeline, String token, String sha) {
        CommitStatus[] statuses = {};

        HttpRequest request = new HttpRequest(HttpMethod.GET,
                "https://api.github.com/repos/Azure/azure-sdk-for-java/statuses/" + sha);
        request.setHeader(HttpHeaderName.AUTHORIZATION, "token " + token)
                .setHeader(HttpHeaderName.ACCEPT, "application/json")
                .setHeader(HttpHeaderName.CONTENT_TYPE, "application/json");

        HttpResponse response = httpPipeline.send(request).block();

        if (response.getStatusCode() == 200) {
            String body = response.getBodyAsString().block();
            try {
                statuses = SERIALIZER_ADAPTER.deserialize(body, statuses.getClass(), SerializerEncoding.JSON);
                return statuses;
            } catch (IOException e) {
                LOGGER.error("error in response body {}", body);
                throw new HttpResponseException(response);
            } finally {
                response.close();
            }
        } else {
            LOGGER.error("error in response code {}, body {}", response.getStatusCode(), response.getBodyAsString().block());
            response.close();
            throw new HttpResponseException(response);
        }
    }

    private static final TypeReference<Map<String, Object>> DICT
            = new TypeReference<Map<String, Object>>() { };
    public static Map<String, Object> getDefinition(DevManager manager, String organization, String project, Integer id) {
        HttpRequest request = new HttpRequest(
                HttpMethod.GET,
                String.format("https://dev.azure.com/%s/%s/_apis/build/definitions/%s?api-version=7.2-preview", organization, project, id.toString()));
        request.setHeader(HttpHeaderName.CONTENT_TYPE, "application/json");
        HttpResponse response = manager.serviceClient().getHttpPipeline().send(request).block();
        System.out.println("response status code: " + response.getStatusCode());
        if (response.getStatusCode() == 200) {
            String body = response.getBodyAsString().block();
            response.close();
            try {
                return SERIALIZER_ADAPTER.deserialize(body, DICT.getJavaType(), SerializerEncoding.JSON);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        } else {
            System.out.println("response body: " + response.getBodyAsString().block());
            response.close();

            throw new IllegalStateException("failed to get definition: " + id);
        }
    }

    public static boolean isDefinitionEnabled(Map<String, Object> definition) {
        return ("enabled".equalsIgnoreCase(definition.get("queueStatus").toString()));
    }

    public static void enableDefinition(DevManager manager, String organization, String project, Integer id, Map<String, Object> definition) {
        definition.put("queueStatus", "enabled");
        HttpRequest request = new HttpRequest(
                HttpMethod.PUT,
                String.format("https://dev.azure.com/%s/%s/_apis/build/definitions/%s?api-version=7.2-preview", organization, project, id.toString()));
        request.setHeader(HttpHeaderName.CONTENT_TYPE, "application/json");
        try {
            request.setBody(SERIALIZER_ADAPTER.serialize(definition, SerializerEncoding.JSON));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        HttpResponse response = manager.serviceClient().getHttpPipeline().send(request).block();
        System.out.println("response status code: " + response.getStatusCode());
        if (response.getStatusCode() == 200) {
            response.close();
        } else {
            System.out.println("response body: " + response.getBodyAsString().block());
            response.close();

            throw new IllegalStateException("failed to update definition: " + id);
        }
    }

    @SuppressWarnings("unchecked")
    public static void prReady(HttpPipeline httpPipeline, String token, int prNumber) {
        String query = "{repository(owner: \"Azure\", name: \"azure-sdk-for-java\") {pullRequest(number: " + prNumber + ") {id}}}";

        HttpRequest request = new HttpRequest(HttpMethod.POST,
                "https://api.github.com/graphql");
        request.setBody("{\"query\": \"" + query.replace("\"", "\\\"") + "\"}");
        request.setHeader(HttpHeaderName.AUTHORIZATION, "bearer " + token)
                .setHeader(HttpHeaderName.ACCEPT, "application/json")
                .setHeader(HttpHeaderName.CONTENT_TYPE, "application/json");

        HttpResponse response = httpPipeline.send(request).block();

        String id = null;
        if (response.getStatusCode() == 200) {
            String body = response.getBodyAsString().block();
            try {
                Map<String, Object> json = SERIALIZER_ADAPTER.deserialize(body, Map.class, SerializerEncoding.JSON);
                id = ((Map<String, String>) ((Map<String, Object>) ((Map<String, Object>) json.get("data")).get("repository")).get("pullRequest")).get("id");
            } catch (IOException e) {
                throw new HttpResponseException(response);
            } finally {
                response.close();
            }
        } else {
            LOGGER.error("error in response code {}, body {}", response.getStatusCode(), response.getBodyAsString().block());
            response.close();
            throw new HttpResponseException(response);
        }

        String mutation = "mutation {markPullRequestReadyForReview(input: {pullRequestId: \"" + id + "\"}) {pullRequest{id,number,isDraft}}}";

        request = new HttpRequest(HttpMethod.POST,
                "https://api.github.com/graphql");
        request.setBody("{\"query\": \"" + mutation.replace("\"", "\\\"") + "\"}");
        request.setHeader(HttpHeaderName.AUTHORIZATION, "bearer " + token)
                .setHeader(HttpHeaderName.ACCEPT, "application/json")
                .setHeader(HttpHeaderName.CONTENT_TYPE, "application/json");

        response = httpPipeline.send(request).block();

        if (response.getStatusCode() == 200) {
            response.close();
        } else {
            LOGGER.error("error in response code {}, body {}", response.getStatusCode(), response.getBodyAsString().block());
            response.close();
            throw new HttpResponseException(response);
        }
    }

    public static void promptMessageAndWait(InputStream in, PrintStream out, String message) {
        out.println(message);
        Scanner s = new Scanner(in);
        while (true) {
            String input = s.nextLine();
            if ("y".equals(input.toLowerCase(Locale.ROOT)) || "yes".equals(input.toLowerCase(Locale.ROOT))) {
                break;
            }
        }
    }

    public static void openUrl(String url) {
        Runtime rt = Runtime.getRuntime();

        try {
            String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
            if (os.contains("win")) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                rt.exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                rt.exec("xdg-open " + url);
            } else {
                LOGGER.error("Browser could not be opened - please open {} in a browser on this device.", url);
            }
        } catch (IOException e) {
            LOGGER.error("Browser could not be opened - please open {} in a browser on this device.", url);
        }
    }

    private static final String SPEC_REPO_PATH_PREFIX = "https://raw.githubusercontent.com/Azure/azure-rest-api-specs/main/";
    private static final String SPEC_REPO_SPEC_PATH_PREFIX = "https://raw.githubusercontent.com/Azure/azure-rest-api-specs/main/specification/";

    public static ReadmeConfigure getReadmeConfigure(HttpPipeline httpPipeline, String swagger) throws MalformedURLException {
        String readmeUrl = swagger.contains("/")
                ? SPEC_REPO_PATH_PREFIX + swagger
                : SPEC_REPO_SPEC_PATH_PREFIX + swagger + "/resource-manager/readme.md";
        return ReadmeConfigure.parseReadme(httpPipeline, new URL(readmeUrl));
    }
}
