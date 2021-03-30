// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.dev.fluent.models.TimelineInner;
import java.util.UUID;

/** An instance of this class provides access to all the operations defined in TimelinesClient. */
public interface TimelinesClient {
    /**
     * Gets details for a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The buildId parameter.
     * @param timelineId The timelineId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details for a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TimelineInner get(String organization, String project, int buildId, UUID timelineId);

    /**
     * Gets details for a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The buildId parameter.
     * @param timelineId The timelineId parameter.
     * @param changeId The changeId parameter.
     * @param planId The planId parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details for a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<TimelineInner> getWithResponse(
        String organization,
        String project,
        int buildId,
        UUID timelineId,
        Integer changeId,
        UUID planId,
        Context context);
}
