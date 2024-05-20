// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.dev.fluent.models.PropertiesCollectionInner;

/**
 * An instance of this class provides access to all the operations defined in PropertiesClient.
 */
public interface PropertiesClient {
    /**
     * Gets properties for a build.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param filter A comma-delimited list of properties. If specified, filters to these specific properties.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties for a build along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<PropertiesCollectionInner> getBuildPropertiesWithResponse(String organization, String project, int buildId,
        String filter, Context context);

    /**
     * Gets properties for a build.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties for a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PropertiesCollectionInner getBuildProperties(String organization, String project, int buildId);

    /**
     * Updates properties for a build.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param body Any object.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the class represents a property bag as a collection of key-value pairs along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<PropertiesCollectionInner> updateBuildPropertiesWithResponse(String organization, String project,
        int buildId, Object body, Context context);

    /**
     * Updates properties for a build.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param body Any object.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the class represents a property bag as a collection of key-value pairs.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PropertiesCollectionInner updateBuildProperties(String organization, String project, int buildId, Object body);

    /**
     * Gets properties for a definition.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param definitionId The ID of the definition.
     * @param filter A comma-delimited list of properties. If specified, filters to these specific properties.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties for a definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<PropertiesCollectionInner> getDefinitionPropertiesWithResponse(String organization, String project,
        int definitionId, String filter, Context context);

    /**
     * Gets properties for a definition.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param definitionId The ID of the definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties for a definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PropertiesCollectionInner getDefinitionProperties(String organization, String project, int definitionId);

    /**
     * Updates properties for a definition.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param definitionId The ID of the definition.
     * @param body Any object.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the class represents a property bag as a collection of key-value pairs along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<PropertiesCollectionInner> updateDefinitionPropertiesWithResponse(String organization, String project,
        int definitionId, Object body, Context context);

    /**
     * Updates properties for a definition.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param definitionId The ID of the definition.
     * @param body Any object.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the class represents a property bag as a collection of key-value pairs.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    PropertiesCollectionInner updateDefinitionProperties(String organization, String project, int definitionId,
        Object body);
}
