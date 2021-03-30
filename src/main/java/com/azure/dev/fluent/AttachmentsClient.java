// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.dev.fluent.models.AttachmentInner;
import java.util.List;
import java.util.UUID;

/** An instance of this class provides access to all the operations defined in AttachmentsClient. */
public interface AttachmentsClient {
    /**
     * Gets a specific attachment.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param timelineId The ID of the timeline.
     * @param recordId The ID of the timeline record.
     * @param type The type of the attachment.
     * @param name The name of the attachment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void get(
        String organization, String project, int buildId, UUID timelineId, UUID recordId, String type, String name);

    /**
     * Gets a specific attachment.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param timelineId The ID of the timeline.
     * @param recordId The ID of the timeline record.
     * @param type The type of the attachment.
     * @param name The name of the attachment.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific attachment.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> getWithResponse(
        String organization,
        String project,
        int buildId,
        UUID timelineId,
        UUID recordId,
        String type,
        String name,
        Context context);

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of attachments of a specific type that are associated with a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    List<AttachmentInner> list(String organization, String project, int buildId, String type);

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of attachments of a specific type that are associated with a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<List<AttachmentInner>> listWithResponse(
        String organization, String project, int buildId, String type, Context context);
}
