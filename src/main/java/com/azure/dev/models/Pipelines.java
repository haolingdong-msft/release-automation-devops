// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import java.util.List;

/** Resource collection API of Pipelines. */
public interface Pipelines {
    /**
     * Create a pipeline.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param body Input parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return definition of a pipeline.
     */
    Pipeline create(String organization, String project, CreatePipelineParameters body);

    /**
     * Create a pipeline.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param body Input parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return definition of a pipeline.
     */
    Response<Pipeline> createWithResponse(
        String organization, String project, CreatePipelineParameters body, Context context);

    /**
     * Get a list of pipelines.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of pipelines.
     */
    List<Pipeline> list(String organization, String project);

    /**
     * Get a list of pipelines.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param orderBy A sort expression. Defaults to "name asc".
     * @param top The maximum number of pipelines to return.
     * @param continuationToken A continuation token from a previous request, to retrieve the next page of results.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of pipelines.
     */
    Response<List<Pipeline>> listWithResponse(
        String organization, String project, String orderBy, Integer top, String continuationToken, Context context);

    /**
     * Gets a pipeline, optionally at the specified version.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId The pipeline ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a pipeline, optionally at the specified version.
     */
    Pipeline get(String organization, String project, int pipelineId);

    /**
     * Gets a pipeline, optionally at the specified version.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId The pipeline ID.
     * @param pipelineVersion The pipeline version.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a pipeline, optionally at the specified version.
     */
    Response<Pipeline> getWithResponse(
        String organization, String project, int pipelineId, Integer pipelineVersion, Context context);
}
