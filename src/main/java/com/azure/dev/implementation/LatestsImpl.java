// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.LatestsClient;
import com.azure.dev.fluent.models.BuildInner;
import com.azure.dev.models.Build;
import com.azure.dev.models.Latests;
import com.fasterxml.jackson.annotation.JsonIgnore;

public final class LatestsImpl implements Latests {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(LatestsImpl.class);

    private final LatestsClient innerClient;

    private final com.azure.dev.DevManager serviceManager;

    public LatestsImpl(LatestsClient innerClient, com.azure.dev.DevManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Build get(String organization, String project, String definition) {
        BuildInner inner = this.serviceClient().get(organization, project, definition);
        if (inner != null) {
            return new BuildImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Build> getWithResponse(
        String organization, String project, String definition, String branchName, Context context) {
        Response<BuildInner> inner =
            this.serviceClient().getWithResponse(organization, project, definition, branchName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new BuildImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private LatestsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
