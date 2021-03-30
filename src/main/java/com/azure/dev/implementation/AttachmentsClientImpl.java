// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.AttachmentsClient;
import com.azure.dev.fluent.models.AttachmentInner;
import java.util.List;
import java.util.UUID;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in AttachmentsClient. */
public final class AttachmentsClientImpl implements AttachmentsClient {
    private final ClientLogger logger = new ClientLogger(AttachmentsClientImpl.class);

    /** The proxy service used to perform REST calls. */
    private final AttachmentsService service;

    /** The service client containing this operation class. */
    private final DevClientImpl client;

    /**
     * Initializes an instance of AttachmentsClientImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    AttachmentsClientImpl(DevClientImpl client) {
        this.service =
            RestProxy.create(AttachmentsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for DevClientAttachments to be used by the proxy service to perform REST
     * calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "DevClientAttachments")
    private interface AttachmentsService {
        @Headers({"Accept: application/json;q=0.9", "Content-Type: application/json"})
        @Get("/{organization}/{project}/_apis/build/builds/{buildId}/{timelineId}/{recordId}/attachments/{type}/{name}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<Void>> get(
            @HostParam("$host") String endpoint,
            @PathParam("organization") String organization,
            @PathParam("project") String project,
            @PathParam("buildId") int buildId,
            @PathParam("timelineId") UUID timelineId,
            @PathParam("recordId") UUID recordId,
            @PathParam("type") String type,
            @PathParam("name") String name,
            @QueryParam("api-version") String apiVersion,
            Context context);

        @Headers({"Content-Type: application/json"})
        @Get("/{organization}/{project}/_apis/build/builds/{buildId}/attachments/{type}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<List<AttachmentInner>>> list(
            @HostParam("$host") String endpoint,
            @PathParam("organization") String organization,
            @PathParam("project") String project,
            @PathParam("buildId") int buildId,
            @PathParam("type") String type,
            @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept,
            Context context);
    }

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
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific attachment.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<Void>> getWithResponseAsync(
        String organization, String project, int buildId, UUID timelineId, UUID recordId, String type, String name) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (timelineId == null) {
            return Mono.error(new IllegalArgumentException("Parameter timelineId is required and cannot be null."));
        }
        if (recordId == null) {
            return Mono.error(new IllegalArgumentException("Parameter recordId is required and cannot be null."));
        }
        if (type == null) {
            return Mono.error(new IllegalArgumentException("Parameter type is required and cannot be null."));
        }
        if (name == null) {
            return Mono.error(new IllegalArgumentException("Parameter name is required and cannot be null."));
        }
        final String apiVersion = "6.0";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .get(
                            this.client.getEndpoint(),
                            organization,
                            project,
                            buildId,
                            timelineId,
                            recordId,
                            type,
                            name,
                            apiVersion,
                            context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

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
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific attachment.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<Void>> getWithResponseAsync(
        String organization,
        String project,
        int buildId,
        UUID timelineId,
        UUID recordId,
        String type,
        String name,
        Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (timelineId == null) {
            return Mono.error(new IllegalArgumentException("Parameter timelineId is required and cannot be null."));
        }
        if (recordId == null) {
            return Mono.error(new IllegalArgumentException("Parameter recordId is required and cannot be null."));
        }
        if (type == null) {
            return Mono.error(new IllegalArgumentException("Parameter type is required and cannot be null."));
        }
        if (name == null) {
            return Mono.error(new IllegalArgumentException("Parameter name is required and cannot be null."));
        }
        final String apiVersion = "6.0";
        context = this.client.mergeContext(context);
        return service
            .get(
                this.client.getEndpoint(),
                organization,
                project,
                buildId,
                timelineId,
                recordId,
                type,
                name,
                apiVersion,
                context);
    }

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
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific attachment.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Void> getAsync(
        String organization, String project, int buildId, UUID timelineId, UUID recordId, String type, String name) {
        return getWithResponseAsync(organization, project, buildId, timelineId, recordId, type, name)
            .flatMap((Response<Void> res) -> Mono.empty());
    }

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
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void get(
        String organization, String project, int buildId, UUID timelineId, UUID recordId, String type, String name) {
        getAsync(organization, project, buildId, timelineId, recordId, type, name).block();
    }

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
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific attachment.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> getWithResponse(
        String organization,
        String project,
        int buildId,
        UUID timelineId,
        UUID recordId,
        String type,
        String name,
        Context context) {
        return getWithResponseAsync(organization, project, buildId, timelineId, recordId, type, name, context).block();
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of attachments of a specific type that are associated with a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<List<AttachmentInner>>> listWithResponseAsync(
        String organization, String project, int buildId, String type) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (type == null) {
            return Mono.error(new IllegalArgumentException("Parameter type is required and cannot be null."));
        }
        final String apiVersion = "6.0";
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .list(
                            this.client.getEndpoint(),
                            organization,
                            project,
                            buildId,
                            type,
                            apiVersion,
                            accept,
                            context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of attachments of a specific type that are associated with a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<List<AttachmentInner>>> listWithResponseAsync(
        String organization, String project, int buildId, String type, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (type == null) {
            return Mono.error(new IllegalArgumentException("Parameter type is required and cannot be null."));
        }
        final String apiVersion = "6.0";
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .list(this.client.getEndpoint(), organization, project, buildId, type, apiVersion, accept, context);
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of attachments of a specific type that are associated with a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<List<AttachmentInner>> listAsync(String organization, String project, int buildId, String type) {
        return listWithResponseAsync(organization, project, buildId, type)
            .flatMap(
                (Response<List<AttachmentInner>> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of attachments of a specific type that are associated with a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<AttachmentInner> list(String organization, String project, int buildId, String type) {
        return listAsync(organization, project, buildId, type).block();
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of attachments of a specific type that are associated with a build.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<List<AttachmentInner>> listWithResponse(
        String organization, String project, int buildId, String type, Context context) {
        return listWithResponseAsync(organization, project, buildId, type, context).block();
    }
}
