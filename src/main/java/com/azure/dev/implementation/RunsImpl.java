// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.RunsClient;
import com.azure.dev.fluent.models.RunInner;
import com.azure.dev.models.Run;
import com.azure.dev.models.RunPipelineParameters;
import com.azure.dev.models.Runs;

public final class RunsImpl implements Runs {
    private static final ClientLogger LOGGER = new ClientLogger(RunsImpl.class);

    private final RunsClient innerClient;

    private final com.azure.dev.DevManager serviceManager;

    public RunsImpl(RunsClient innerClient, com.azure.dev.DevManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<Run> list(String organization, String project, int pipelineId) {
        PagedIterable<RunInner> inner = this.serviceClient().list(organization, project, pipelineId);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new RunImpl(inner1, this.manager()));
    }

    public PagedIterable<Run> list(String organization, String project, int pipelineId, Context context) {
        PagedIterable<RunInner> inner = this.serviceClient().list(organization, project, pipelineId, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new RunImpl(inner1, this.manager()));
    }

    public Response<Run> runPipelineWithResponse(String organization, String project, int pipelineId,
        RunPipelineParameters body, Integer pipelineVersion, Context context) {
        Response<RunInner> inner = this.serviceClient()
            .runPipelineWithResponse(organization, project, pipelineId, body, pipelineVersion, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new RunImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public Run runPipeline(String organization, String project, int pipelineId, RunPipelineParameters body) {
        RunInner inner = this.serviceClient().runPipeline(organization, project, pipelineId, body);
        if (inner != null) {
            return new RunImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Run> getWithResponse(String organization, String project, int pipelineId, int runId,
        Context context) {
        Response<RunInner> inner
            = this.serviceClient().getWithResponse(organization, project, pipelineId, runId, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new RunImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public Run get(String organization, String project, int pipelineId, int runId) {
        RunInner inner = this.serviceClient().get(organization, project, pipelineId, runId);
        if (inner != null) {
            return new RunImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private RunsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
