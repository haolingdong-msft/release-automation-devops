// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.dev.fluent.models.BuildReportMetadataInner;

/** An instance of this class provides access to all the operations defined in ReportsClient. */
public interface ReportsClient {
    /**
     * Gets a build report.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a build report.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BuildReportMetadataInner get(String organization, String project, int buildId);

    /**
     * Gets a build report.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param type The type parameter.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a build report.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BuildReportMetadataInner> getWithResponse(
        String organization, String project, int buildId, String type, Context context);
}
