// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.TemplatesClient;
import com.azure.dev.fluent.models.BuildDefinitionTemplateInner;
import com.azure.dev.models.BuildDefinitionTemplate;
import com.azure.dev.models.Templates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class TemplatesImpl implements Templates {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(TemplatesImpl.class);

    private final TemplatesClient innerClient;

    private final com.azure.dev.DevManager serviceManager;

    public TemplatesImpl(TemplatesClient innerClient, com.azure.dev.DevManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public List<BuildDefinitionTemplate> list(String organization, String project) {
        List<BuildDefinitionTemplateInner> inner = this.serviceClient().list(organization, project);
        if (inner != null) {
            return Collections
                .unmodifiableList(
                    inner
                        .stream()
                        .map(inner1 -> new BuildDefinitionTemplateImpl(inner1, this.manager()))
                        .collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public Response<List<BuildDefinitionTemplate>> listWithResponse(
        String organization, String project, Context context) {
        Response<List<BuildDefinitionTemplateInner>> inner =
            this.serviceClient().listWithResponse(organization, project, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                inner
                    .getValue()
                    .stream()
                    .map(inner1 -> new BuildDefinitionTemplateImpl(inner1, this.manager()))
                    .collect(Collectors.toList()));
        } else {
            return null;
        }
    }

    public void delete(String organization, String project, String templateId) {
        this.serviceClient().delete(organization, project, templateId);
    }

    public Response<Void> deleteWithResponse(String organization, String project, String templateId, Context context) {
        return this.serviceClient().deleteWithResponse(organization, project, templateId, context);
    }

    public BuildDefinitionTemplate get(String organization, String project, String templateId) {
        BuildDefinitionTemplateInner inner = this.serviceClient().get(organization, project, templateId);
        if (inner != null) {
            return new BuildDefinitionTemplateImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<BuildDefinitionTemplate> getWithResponse(
        String organization, String project, String templateId, Context context) {
        Response<BuildDefinitionTemplateInner> inner =
            this.serviceClient().getWithResponse(organization, project, templateId, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new BuildDefinitionTemplateImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public BuildDefinitionTemplate saveTemplate(
        String organization, String project, String templateId, BuildDefinitionTemplateInner body) {
        BuildDefinitionTemplateInner inner = this.serviceClient().saveTemplate(organization, project, templateId, body);
        if (inner != null) {
            return new BuildDefinitionTemplateImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<BuildDefinitionTemplate> saveTemplateWithResponse(
        String organization, String project, String templateId, BuildDefinitionTemplateInner body, Context context) {
        Response<BuildDefinitionTemplateInner> inner =
            this.serviceClient().saveTemplateWithResponse(organization, project, templateId, body, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new BuildDefinitionTemplateImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private TemplatesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
