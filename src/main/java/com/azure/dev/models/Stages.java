// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of Stages.
 */
public interface Stages {
    /**
     * Update a build stage.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param buildId The buildId parameter.
     * @param stageRefName The stageRefName parameter.
     * @param project Project ID or project name.
     * @param body The body parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> updateWithResponse(String organization, int buildId, String stageRefName, String project,
        UpdateStageParameters body, Context context);

    /**
     * Update a build stage.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param buildId The buildId parameter.
     * @param stageRefName The stageRefName parameter.
     * @param project Project ID or project name.
     * @param body The body parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void update(String organization, int buildId, String stageRefName, String project, UpdateStageParameters body);
}
