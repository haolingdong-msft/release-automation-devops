// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.dev.fluent.models.FolderInner;
import com.azure.dev.models.FolderQueryOrder;
import java.util.List;

/** An instance of this class provides access to all the operations defined in FoldersClient. */
public interface FoldersClient {
    /**
     * Creates a new folder.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param path The full path of the folder.
     * @param body The folder.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a folder that contains build definitions.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    FolderInner create(String organization, String project, String path, FolderInner body);

    /**
     * Creates a new folder.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param path The full path of the folder.
     * @param body The folder.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a folder that contains build definitions.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<FolderInner> createWithResponse(
        String organization, String project, String path, FolderInner body, Context context);

    /**
     * Deletes a definition folder. Definitions and their corresponding builds will also be deleted.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param path The full path to the folder.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String organization, String project, String path);

    /**
     * Deletes a definition folder. Definitions and their corresponding builds will also be deleted.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param path The full path to the folder.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String organization, String project, String path, Context context);

    /**
     * Updates an existing folder at given existing path.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param path The full path to the folder.
     * @param body The new version of the folder.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a folder that contains build definitions.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    FolderInner update(String organization, String project, String path, FolderInner body);

    /**
     * Updates an existing folder at given existing path.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param path The full path to the folder.
     * @param body The new version of the folder.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a folder that contains build definitions.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<FolderInner> updateWithResponse(
        String organization, String project, String path, FolderInner body, Context context);

    /**
     * Gets a list of build definition folders.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param path The path to start with.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of build definition folders.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<FolderInner> list(String organization, String project, String path);

    /**
     * Gets a list of build definition folders.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param path The path to start with.
     * @param queryOrder The order in which folders should be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of build definition folders.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<FolderInner>> listWithResponse(
        String organization, String project, String path, FolderQueryOrder queryOrder, Context context);
}
