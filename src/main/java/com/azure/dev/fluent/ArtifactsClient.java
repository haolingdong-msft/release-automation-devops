// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.dev.fluent.models.ArtifactInner;
import com.azure.dev.fluent.models.BuildArtifactInner;
import com.azure.dev.models.GetArtifactExpandOptions;
import java.util.List;

/** An instance of this class provides access to all the operations defined in ArtifactsClient. */
public interface ArtifactsClient {
    /**
     * Associates an artifact with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param body The artifact.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents an artifact produced by a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BuildArtifactInner create(String organization, String project, int buildId, BuildArtifactInner body);

    /**
     * Associates an artifact with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param body The artifact.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents an artifact produced by a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BuildArtifactInner> createWithResponse(
        String organization, String project, int buildId, BuildArtifactInner body, Context context);

    /**
     * Gets all artifacts for a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all artifacts for a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<BuildArtifactInner> list(String organization, String project, int buildId);

    /**
     * Gets all artifacts for a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all artifacts for a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<BuildArtifactInner>> listWithResponse(
        String organization, String project, int buildId, Context context);

    /**
     * Gets a specific artifact for a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific artifact for a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BuildArtifactInner getArtifact(String organization, String project, int buildId, String artifactName);

    /**
     * Gets a specific artifact for a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific artifact for a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BuildArtifactInner> getArtifactWithResponse(
        String organization, String project, int buildId, String artifactName, Context context);

    /**
     * Gets a file from the build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @param fileId The primary key for the file.
     * @param fileName The name that the file will be set to.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void getFile(String organization, String project, int buildId, String artifactName, String fileId, String fileName);

    /**
     * Gets a file from the build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @param fileId The primary key for the file.
     * @param fileName The name that the file will be set to.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a file from the build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> getFileWithResponse(
        String organization,
        String project,
        int buildId,
        String artifactName,
        String fileId,
        String fileName,
        Context context);

    /**
     * Get a specific artifact from a pipeline run.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId ID of the pipeline.
     * @param runId ID of the run of that pipeline.
     * @param artifactName Name of the artifact.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific artifact from a pipeline run.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ArtifactInner get(String organization, String project, int pipelineId, int runId, String artifactName);

    /**
     * Get a specific artifact from a pipeline run.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId ID of the pipeline.
     * @param runId ID of the run of that pipeline.
     * @param artifactName Name of the artifact.
     * @param expand Expand options. Default is None.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific artifact from a pipeline run.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ArtifactInner> getWithResponse(
        String organization,
        String project,
        int pipelineId,
        int runId,
        String artifactName,
        GetArtifactExpandOptions expand,
        Context context);
}
