// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.ControllersClient;
import com.azure.dev.fluent.models.BuildControllerInner;
import com.azure.dev.models.BuildController;
import com.azure.dev.models.Controllers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class ControllersImpl implements Controllers {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ControllersImpl.class);

    private final ControllersClient innerClient;

    private final com.azure.dev.DevManager serviceManager;

    public ControllersImpl(ControllersClient innerClient, com.azure.dev.DevManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public List<BuildController> list(String organization) {
        List<BuildControllerInner> inner = this.serviceClient().list(organization);
        if (inner != null) {
            return Collections
                .unmodifiableList(
                    inner
                        .stream()
                        .map(inner1 -> new BuildControllerImpl(inner1, this.manager()))
                        .collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public Response<List<BuildController>> listWithResponse(String organization, String name, Context context) {
        Response<List<BuildControllerInner>> inner = this.serviceClient().listWithResponse(organization, name, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                inner
                    .getValue()
                    .stream()
                    .map(inner1 -> new BuildControllerImpl(inner1, this.manager()))
                    .collect(Collectors.toList()));
        } else {
            return null;
        }
    }

    public BuildController get(String organization, int controllerId) {
        BuildControllerInner inner = this.serviceClient().get(organization, controllerId);
        if (inner != null) {
            return new BuildControllerImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<BuildController> getWithResponse(String organization, int controllerId, Context context) {
        Response<BuildControllerInner> inner =
            this.serviceClient().getWithResponse(organization, controllerId, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new BuildControllerImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private ControllersClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
