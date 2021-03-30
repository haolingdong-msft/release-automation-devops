// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.PipelinesClient;
import com.azure.dev.fluent.models.PipelineInner;
import com.azure.dev.models.CreatePipelineParameters;
import com.azure.dev.models.Pipeline;
import com.azure.dev.models.Pipelines;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class PipelinesImpl implements Pipelines {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PipelinesImpl.class);

    private final PipelinesClient innerClient;

    private final com.azure.dev.DevManager serviceManager;

    public PipelinesImpl(PipelinesClient innerClient, com.azure.dev.DevManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Pipeline create(String organization, String project, CreatePipelineParameters body) {
        PipelineInner inner = this.serviceClient().create(organization, project, body);
        if (inner != null) {
            return new PipelineImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Pipeline> createWithResponse(
        String organization, String project, CreatePipelineParameters body, Context context) {
        Response<PipelineInner> inner = this.serviceClient().createWithResponse(organization, project, body, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new PipelineImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public List<Pipeline> list(String organization, String project) {
        List<PipelineInner> inner = this.serviceClient().list(organization, project);
        if (inner != null) {
            return Collections
                .unmodifiableList(
                    inner
                        .stream()
                        .map(inner1 -> new PipelineImpl(inner1, this.manager()))
                        .collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public Response<List<Pipeline>> listWithResponse(
        String organization, String project, String orderBy, Integer top, String continuationToken, Context context) {
        Response<List<PipelineInner>> inner =
            this.serviceClient().listWithResponse(organization, project, orderBy, top, continuationToken, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                inner
                    .getValue()
                    .stream()
                    .map(inner1 -> new PipelineImpl(inner1, this.manager()))
                    .collect(Collectors.toList()));
        } else {
            return null;
        }
    }

    public Pipeline get(String organization, String project, int pipelineId) {
        PipelineInner inner = this.serviceClient().get(organization, project, pipelineId);
        if (inner != null) {
            return new PipelineImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Pipeline> getWithResponse(
        String organization, String project, int pipelineId, Integer pipelineVersion, Context context) {
        Response<PipelineInner> inner =
            this.serviceClient().getWithResponse(organization, project, pipelineId, pipelineVersion, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new PipelineImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private PipelinesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
