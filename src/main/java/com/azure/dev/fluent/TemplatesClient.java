// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.dev.fluent.models.BuildDefinitionTemplateInner;
import java.util.List;

/** An instance of this class provides access to all the operations defined in TemplatesClient. */
public interface TemplatesClient {
    /**
     * Gets all definition templates.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all definition templates.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<BuildDefinitionTemplateInner> list(String organization, String project);

    /**
     * Gets all definition templates.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all definition templates.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<BuildDefinitionTemplateInner>> listWithResponse(String organization, String project, Context context);

    /**
     * Deletes a build definition template.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String organization, String project, String templateId);

    /**
     * Deletes a build definition template.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String organization, String project, String templateId, Context context);

    /**
     * Gets a specific build definition template.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the requested template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific build definition template.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BuildDefinitionTemplateInner get(String organization, String project, String templateId);

    /**
     * Gets a specific build definition template.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the requested template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific build definition template.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BuildDefinitionTemplateInner> getWithResponse(
        String organization, String project, String templateId, Context context);

    /**
     * Updates an existing build definition template.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param body The new version of the template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a template from which new build definitions can be created.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BuildDefinitionTemplateInner saveTemplate(
        String organization, String project, String templateId, BuildDefinitionTemplateInner body);

    /**
     * Updates an existing build definition template.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param body The new version of the template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a template from which new build definitions can be created.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BuildDefinitionTemplateInner> saveTemplateWithResponse(
        String organization, String project, String templateId, BuildDefinitionTemplateInner body, Context context);
}
