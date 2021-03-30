// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.ArtifactsClient;
import com.azure.dev.fluent.models.ArtifactInner;
import com.azure.dev.fluent.models.BuildArtifactInner;
import com.azure.dev.models.Artifact;
import com.azure.dev.models.Artifacts;
import com.azure.dev.models.BuildArtifact;
import com.azure.dev.models.GetArtifactExpandOptions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class ArtifactsImpl implements Artifacts {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ArtifactsImpl.class);

    private final ArtifactsClient innerClient;

    private final com.azure.dev.DevManager serviceManager;

    public ArtifactsImpl(ArtifactsClient innerClient, com.azure.dev.DevManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public BuildArtifact create(String organization, String project, int buildId, BuildArtifactInner body) {
        BuildArtifactInner inner = this.serviceClient().create(organization, project, buildId, body);
        if (inner != null) {
            return new BuildArtifactImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<BuildArtifact> createWithResponse(
        String organization, String project, int buildId, BuildArtifactInner body, Context context) {
        Response<BuildArtifactInner> inner =
            this.serviceClient().createWithResponse(organization, project, buildId, body, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new BuildArtifactImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public List<BuildArtifact> list(String organization, String project, int buildId) {
        List<BuildArtifactInner> inner = this.serviceClient().list(organization, project, buildId);
        if (inner != null) {
            return Collections
                .unmodifiableList(
                    inner
                        .stream()
                        .map(inner1 -> new BuildArtifactImpl(inner1, this.manager()))
                        .collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public Response<List<BuildArtifact>> listWithResponse(
        String organization, String project, int buildId, Context context) {
        Response<List<BuildArtifactInner>> inner =
            this.serviceClient().listWithResponse(organization, project, buildId, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                inner
                    .getValue()
                    .stream()
                    .map(inner1 -> new BuildArtifactImpl(inner1, this.manager()))
                    .collect(Collectors.toList()));
        } else {
            return null;
        }
    }

    public BuildArtifact getArtifact(String organization, String project, int buildId, String artifactName) {
        BuildArtifactInner inner = this.serviceClient().getArtifact(organization, project, buildId, artifactName);
        if (inner != null) {
            return new BuildArtifactImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<BuildArtifact> getArtifactWithResponse(
        String organization, String project, int buildId, String artifactName, Context context) {
        Response<BuildArtifactInner> inner =
            this.serviceClient().getArtifactWithResponse(organization, project, buildId, artifactName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new BuildArtifactImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public void getFile(
        String organization, String project, int buildId, String artifactName, String fileId, String fileName) {
        this.serviceClient().getFile(organization, project, buildId, artifactName, fileId, fileName);
    }

    public Response<Void> getFileWithResponse(
        String organization,
        String project,
        int buildId,
        String artifactName,
        String fileId,
        String fileName,
        Context context) {
        return this
            .serviceClient()
            .getFileWithResponse(organization, project, buildId, artifactName, fileId, fileName, context);
    }

    public Artifact get(String organization, String project, int pipelineId, int runId, String artifactName) {
        ArtifactInner inner = this.serviceClient().get(organization, project, pipelineId, runId, artifactName);
        if (inner != null) {
            return new ArtifactImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Artifact> getWithResponse(
        String organization,
        String project,
        int pipelineId,
        int runId,
        String artifactName,
        GetArtifactExpandOptions expand,
        Context context) {
        Response<ArtifactInner> inner =
            this
                .serviceClient()
                .getWithResponse(organization, project, pipelineId, runId, artifactName, expand, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new ArtifactImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private ArtifactsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
