// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/** Resource collection API of Latests. */
public interface Latests {
    /**
     * Gets the latest build for a definition, optionally scoped to a specific branch.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param definition definition name with optional leading folder path, or the definition id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the latest build for a definition, optionally scoped to a specific branch.
     */
    Build get(String organization, String project, String definition);

    /**
     * Gets the latest build for a definition, optionally scoped to a specific branch.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param definition definition name with optional leading folder path, or the definition id.
     * @param branchName optional parameter that indicates the specific branch to use.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the latest build for a definition, optionally scoped to a specific branch.
     */
    Response<Build> getWithResponse(
        String organization, String project, String definition, String branchName, Context context);
}
