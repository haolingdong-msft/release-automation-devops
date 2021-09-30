// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.dev.fluent.models.RunInner;
import com.azure.dev.models.RunPipelineParameters;

/** An instance of this class provides access to all the operations defined in RunsClient. */
public interface RunsClient {
    /**
     * Gets top 10000 runs for a particular pipeline.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId The pipeline id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return top 10000 runs for a particular pipeline.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<RunInner> list(String organization, String project, int pipelineId);

    /**
     * Gets top 10000 runs for a particular pipeline.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId The pipeline id.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return top 10000 runs for a particular pipeline.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<RunInner> list(String organization, String project, int pipelineId, Context context);

    /**
     * Runs a pipeline.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId The pipeline ID.
     * @param body Optional additional parameters for this run.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    RunInner runPipeline(String organization, String project, int pipelineId, RunPipelineParameters body);

    /**
     * Runs a pipeline.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId The pipeline ID.
     * @param body Optional additional parameters for this run.
     * @param pipelineVersion The pipeline version.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<RunInner> runPipelineWithResponse(
        String organization,
        String project,
        int pipelineId,
        RunPipelineParameters body,
        Integer pipelineVersion,
        Context context);

    /**
     * Gets a run for a particular pipeline.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId The pipeline id.
     * @param runId The run id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a run for a particular pipeline.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    RunInner get(String organization, String project, int pipelineId, int runId);

    /**
     * Gets a run for a particular pipeline.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param pipelineId The pipeline id.
     * @param runId The run id.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a run for a particular pipeline.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<RunInner> getWithResponse(String organization, String project, int pipelineId, int runId, Context context);
}
