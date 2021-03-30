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
import com.azure.dev.fluent.BadgesClient;
import java.util.UUID;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in BadgesClient. */
public final class BadgesClientImpl implements BadgesClient {
    private final ClientLogger logger = new ClientLogger(BadgesClientImpl.class);

    /** The proxy service used to perform REST calls. */
    private final BadgesService service;

    /** The service client containing this operation class. */
    private final DevClientImpl client;

    /**
     * Initializes an instance of BadgesClientImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    BadgesClientImpl(DevClientImpl client) {
        this.service = RestProxy.create(BadgesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for DevClientBadges to be used by the proxy service to perform REST
     * calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "DevClientBadges")
    private interface BadgesService {
        @Headers({"Content-Type: application/json"})
        @Get("/{organization}/_apis/public/build/definitions/{project}/{definitionId}/badge")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<String>> get(
            @HostParam("$host") String endpoint,
            @PathParam("organization") String organization,
            @PathParam("project") UUID project,
            @PathParam("definitionId") int definitionId,
            @QueryParam("branchName") String branchName,
            @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept,
            Context context);

        @Headers({"Content-Type: application/json"})
        @Get("/{organization}/{project}/_apis/build/repos/{repoType}/badge")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<String>> getBuildBadgeData(
            @HostParam("$host") String endpoint,
            @PathParam("organization") String organization,
            @PathParam("project") String project,
            @PathParam("repoType") String repoType,
            @QueryParam("repoId") String repoId,
            @QueryParam("branchName") String branchName,
            @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept,
            Context context);
    }

    /**
     * This endpoint is deprecated. Please see the Build Status REST endpoint.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project The project ID or name.
     * @param definitionId The ID of the definition.
     * @param branchName The name of the branch.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<String>> getWithResponseAsync(
        String organization, UUID project, int definitionId, String branchName) {
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
        final String apiVersion = "6.0";
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .get(
                            this.client.getEndpoint(),
                            organization,
                            project,
                            definitionId,
                            branchName,
                            apiVersion,
                            accept,
                            context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * This endpoint is deprecated. Please see the Build Status REST endpoint.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project The project ID or name.
     * @param definitionId The ID of the definition.
     * @param branchName The name of the branch.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<String>> getWithResponseAsync(
        String organization, UUID project, int definitionId, String branchName, Context context) {
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
        final String apiVersion = "6.0";
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .get(
                this.client.getEndpoint(),
                organization,
                project,
                definitionId,
                branchName,
                apiVersion,
                accept,
                context);
    }

    /**
     * This endpoint is deprecated. Please see the Build Status REST endpoint.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project The project ID or name.
     * @param definitionId The ID of the definition.
     * @param branchName The name of the branch.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<String> getAsync(String organization, UUID project, int definitionId, String branchName) {
        return getWithResponseAsync(organization, project, definitionId, branchName)
            .flatMap(
                (Response<String> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * This endpoint is deprecated. Please see the Build Status REST endpoint.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project The project ID or name.
     * @param definitionId The ID of the definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<String> getAsync(String organization, UUID project, int definitionId) {
        final String branchName = null;
        return getWithResponseAsync(organization, project, definitionId, branchName)
            .flatMap(
                (Response<String> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * This endpoint is deprecated. Please see the Build Status REST endpoint.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project The project ID or name.
     * @param definitionId The ID of the definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public String get(String organization, UUID project, int definitionId) {
        final String branchName = null;
        return getAsync(organization, project, definitionId, branchName).block();
    }

    /**
     * This endpoint is deprecated. Please see the Build Status REST endpoint.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project The project ID or name.
     * @param definitionId The ID of the definition.
     * @param branchName The name of the branch.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<String> getWithResponse(
        String organization, UUID project, int definitionId, String branchName, Context context) {
        return getWithResponseAsync(organization, project, definitionId, branchName, context).block();
    }

    /**
     * Gets a badge that indicates the status of the most recent build for the specified branch.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param repoType The repository type.
     * @param repoId The repository ID.
     * @param branchName The branch name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a badge that indicates the status of the most recent build for the specified branch.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<String>> getBuildBadgeDataWithResponseAsync(
        String organization, String project, String repoType, String repoId, String branchName) {
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
        if (repoType == null) {
            return Mono.error(new IllegalArgumentException("Parameter repoType is required and cannot be null."));
        }
        final String apiVersion = "6.0";
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .getBuildBadgeData(
                            this.client.getEndpoint(),
                            organization,
                            project,
                            repoType,
                            repoId,
                            branchName,
                            apiVersion,
                            accept,
                            context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Gets a badge that indicates the status of the most recent build for the specified branch.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param repoType The repository type.
     * @param repoId The repository ID.
     * @param branchName The branch name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a badge that indicates the status of the most recent build for the specified branch.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<String>> getBuildBadgeDataWithResponseAsync(
        String organization, String project, String repoType, String repoId, String branchName, Context context) {
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
        if (repoType == null) {
            return Mono.error(new IllegalArgumentException("Parameter repoType is required and cannot be null."));
        }
        final String apiVersion = "6.0";
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .getBuildBadgeData(
                this.client.getEndpoint(),
                organization,
                project,
                repoType,
                repoId,
                branchName,
                apiVersion,
                accept,
                context);
    }

    /**
     * Gets a badge that indicates the status of the most recent build for the specified branch.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param repoType The repository type.
     * @param repoId The repository ID.
     * @param branchName The branch name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a badge that indicates the status of the most recent build for the specified branch.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<String> getBuildBadgeDataAsync(
        String organization, String project, String repoType, String repoId, String branchName) {
        return getBuildBadgeDataWithResponseAsync(organization, project, repoType, repoId, branchName)
            .flatMap(
                (Response<String> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Gets a badge that indicates the status of the most recent build for the specified branch.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param repoType The repository type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a badge that indicates the status of the most recent build for the specified branch.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<String> getBuildBadgeDataAsync(String organization, String project, String repoType) {
        final String repoId = null;
        final String branchName = null;
        return getBuildBadgeDataWithResponseAsync(organization, project, repoType, repoId, branchName)
            .flatMap(
                (Response<String> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Gets a badge that indicates the status of the most recent build for the specified branch.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param repoType The repository type.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a badge that indicates the status of the most recent build for the specified branch.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public String getBuildBadgeData(String organization, String project, String repoType) {
        final String repoId = null;
        final String branchName = null;
        return getBuildBadgeDataAsync(organization, project, repoType, repoId, branchName).block();
    }

    /**
     * Gets a badge that indicates the status of the most recent build for the specified branch.
     *
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param repoType The repository type.
     * @param repoId The repository ID.
     * @param branchName The branch name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a badge that indicates the status of the most recent build for the specified branch.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<String> getBuildBadgeDataWithResponse(
        String organization, String project, String repoType, String repoId, String branchName, Context context) {
        return getBuildBadgeDataWithResponseAsync(organization, project, repoType, repoId, branchName, context).block();
    }
}
