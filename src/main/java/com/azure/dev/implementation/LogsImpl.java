// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.LogsClient;
import com.azure.dev.fluent.models.LogCollectionInner;
import com.azure.dev.fluent.models.LogInner;
import com.azure.dev.models.GetLogExpandOptions;
import com.azure.dev.models.Log;
import com.azure.dev.models.LogCollection;
import com.azure.dev.models.Logs;
import com.fasterxml.jackson.annotation.JsonIgnore;

public final class LogsImpl implements Logs {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(LogsImpl.class);

    private final LogsClient innerClient;

    private final com.azure.dev.DevManager serviceManager;

    public LogsImpl(LogsClient innerClient, com.azure.dev.DevManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public LogCollection list(String organization, String project, int pipelineId, int runId) {
        LogCollectionInner inner = this.serviceClient().list(organization, project, pipelineId, runId);
        if (inner != null) {
            return new LogCollectionImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<LogCollection> listWithResponse(
        String organization, String project, int pipelineId, int runId, GetLogExpandOptions expand, Context context) {
        Response<LogCollectionInner> inner =
            this.serviceClient().listWithResponse(organization, project, pipelineId, runId, expand, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new LogCollectionImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public Log get(String organization, String project, int pipelineId, int runId, int logId) {
        LogInner inner = this.serviceClient().get(organization, project, pipelineId, runId, logId);
        if (inner != null) {
            return new LogImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Log> getWithResponse(
        String organization,
        String project,
        int pipelineId,
        int runId,
        int logId,
        GetLogExpandOptions expand,
        Context context) {
        Response<LogInner> inner =
            this.serviceClient().getWithResponse(organization, project, pipelineId, runId, logId, expand, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new LogImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private LogsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
