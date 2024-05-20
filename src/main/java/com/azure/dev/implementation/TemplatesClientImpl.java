// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Put;
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
import com.azure.dev.fluent.TemplatesClient;
import com.azure.dev.fluent.models.BuildDefinitionTemplateInner;
import java.util.List;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in TemplatesClient.
 */
public final class TemplatesClientImpl implements TemplatesClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final TemplatesService service;

    /**
     * The service client containing this operation class.
     */
    private final DevClientImpl client;

    /**
     * Initializes an instance of TemplatesClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    TemplatesClientImpl(DevClientImpl client) {
        this.service
            = RestProxy.create(TemplatesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for DevClientTemplates to be used by the proxy service to perform REST
     * calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "DevClientTemplates")
    public interface TemplatesService {
        @Headers({ "Content-Type: application/json" })
        @Get("/{organization}/{project}/_apis/build/definitions/templates")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<List<BuildDefinitionTemplateInner>>> list(@HostParam("$host") String endpoint,
            @PathParam("organization") String organization, @PathParam("project") String project,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Accept: application/json;q=0.9", "Content-Type: application/json" })
        @Delete("/{organization}/{project}/_apis/build/definitions/templates/{templateId}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<Void>> delete(@HostParam("$host") String endpoint, @PathParam("organization") String organization,
            @PathParam("project") String project, @PathParam("templateId") String templateId,
            @QueryParam("api-version") String apiVersion, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/{organization}/{project}/_apis/build/definitions/templates/{templateId}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<BuildDefinitionTemplateInner>> get(@HostParam("$host") String endpoint,
            @PathParam("organization") String organization, @PathParam("project") String project,
            @PathParam("templateId") String templateId, @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Put("/{organization}/{project}/_apis/build/definitions/templates/{templateId}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<BuildDefinitionTemplateInner>> saveTemplate(@HostParam("$host") String endpoint,
            @PathParam("organization") String organization, @PathParam("project") String project,
            @PathParam("templateId") String templateId, @QueryParam("api-version") String apiVersion,
            @BodyParam("application/json") BuildDefinitionTemplateInner body, @HeaderParam("Accept") String accept,
            Context context);
    }

    /**
     * Gets all definition templates.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all definition templates along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<List<BuildDefinitionTemplateInner>>> listWithResponseAsync(String organization,
        String project) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.list(this.client.getEndpoint(), organization, project,
                this.client.getApiVersion(), accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Gets all definition templates.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all definition templates along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<List<BuildDefinitionTemplateInner>>> listWithResponseAsync(String organization,
        String project, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.list(this.client.getEndpoint(), organization, project, this.client.getApiVersion(), accept,
            context);
    }

    /**
     * Gets all definition templates.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all definition templates on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<List<BuildDefinitionTemplateInner>> listAsync(String organization, String project) {
        return listWithResponseAsync(organization, project).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Gets all definition templates.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all definition templates along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<List<BuildDefinitionTemplateInner>> listWithResponse(String organization, String project,
        Context context) {
        return listWithResponseAsync(organization, project, context).block();
    }

    /**
     * Gets all definition templates.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all definition templates.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<BuildDefinitionTemplateInner> list(String organization, String project) {
        return listWithResponse(organization, project, Context.NONE).getValue();
    }

    /**
     * Deletes a build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<Void>> deleteWithResponseAsync(String organization, String project, String templateId) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (templateId == null) {
            return Mono.error(new IllegalArgumentException("Parameter templateId is required and cannot be null."));
        }
        return FluxUtil
            .withContext(context -> service.delete(this.client.getEndpoint(), organization, project, templateId,
                this.client.getApiVersion(), context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Deletes a build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<Void>> deleteWithResponseAsync(String organization, String project, String templateId,
        Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (templateId == null) {
            return Mono.error(new IllegalArgumentException("Parameter templateId is required and cannot be null."));
        }
        context = this.client.mergeContext(context);
        return service.delete(this.client.getEndpoint(), organization, project, templateId, this.client.getApiVersion(),
            context);
    }

    /**
     * Deletes a build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Void> deleteAsync(String organization, String project, String templateId) {
        return deleteWithResponseAsync(organization, project, templateId).flatMap(ignored -> Mono.empty());
    }

    /**
     * Deletes a build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteWithResponse(String organization, String project, String templateId, Context context) {
        return deleteWithResponseAsync(organization, project, templateId, context).block();
    }

    /**
     * Deletes a build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void delete(String organization, String project, String templateId) {
        deleteWithResponse(organization, project, templateId, Context.NONE);
    }

    /**
     * Gets a specific build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the requested template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific build definition template along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<BuildDefinitionTemplateInner>> getWithResponseAsync(String organization, String project,
        String templateId) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (templateId == null) {
            return Mono.error(new IllegalArgumentException("Parameter templateId is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.get(this.client.getEndpoint(), organization, project, templateId,
                this.client.getApiVersion(), accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Gets a specific build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the requested template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific build definition template along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<BuildDefinitionTemplateInner>> getWithResponseAsync(String organization, String project,
        String templateId, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (templateId == null) {
            return Mono.error(new IllegalArgumentException("Parameter templateId is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.get(this.client.getEndpoint(), organization, project, templateId, this.client.getApiVersion(),
            accept, context);
    }

    /**
     * Gets a specific build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the requested template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific build definition template on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<BuildDefinitionTemplateInner> getAsync(String organization, String project, String templateId) {
        return getWithResponseAsync(organization, project, templateId).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Gets a specific build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the requested template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific build definition template along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BuildDefinitionTemplateInner> getWithResponse(String organization, String project,
        String templateId, Context context) {
        return getWithResponseAsync(organization, project, templateId, context).block();
    }

    /**
     * Gets a specific build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the requested template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific build definition template.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public BuildDefinitionTemplateInner get(String organization, String project, String templateId) {
        return getWithResponse(organization, project, templateId, Context.NONE).getValue();
    }

    /**
     * Updates an existing build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param body The new version of the template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a template from which new build definitions can be created along with {@link Response} on
     * successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<BuildDefinitionTemplateInner>> saveTemplateWithResponseAsync(String organization,
        String project, String templateId, BuildDefinitionTemplateInner body) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (templateId == null) {
            return Mono.error(new IllegalArgumentException("Parameter templateId is required and cannot be null."));
        }
        if (body == null) {
            return Mono.error(new IllegalArgumentException("Parameter body is required and cannot be null."));
        } else {
            body.validate();
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.saveTemplate(this.client.getEndpoint(), organization, project, templateId,
                this.client.getApiVersion(), body, accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Updates an existing build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param body The new version of the template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a template from which new build definitions can be created along with {@link Response} on
     * successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<BuildDefinitionTemplateInner>> saveTemplateWithResponseAsync(String organization,
        String project, String templateId, BuildDefinitionTemplateInner body, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (organization == null) {
            return Mono.error(new IllegalArgumentException("Parameter organization is required and cannot be null."));
        }
        if (project == null) {
            return Mono.error(new IllegalArgumentException("Parameter project is required and cannot be null."));
        }
        if (templateId == null) {
            return Mono.error(new IllegalArgumentException("Parameter templateId is required and cannot be null."));
        }
        if (body == null) {
            return Mono.error(new IllegalArgumentException("Parameter body is required and cannot be null."));
        } else {
            body.validate();
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.saveTemplate(this.client.getEndpoint(), organization, project, templateId,
            this.client.getApiVersion(), body, accept, context);
    }

    /**
     * Updates an existing build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param body The new version of the template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a template from which new build definitions can be created on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<BuildDefinitionTemplateInner> saveTemplateAsync(String organization, String project, String templateId,
        BuildDefinitionTemplateInner body) {
        return saveTemplateWithResponseAsync(organization, project, templateId, body)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Updates an existing build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param body The new version of the template.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a template from which new build definitions can be created along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BuildDefinitionTemplateInner> saveTemplateWithResponse(String organization, String project,
        String templateId, BuildDefinitionTemplateInner body, Context context) {
        return saveTemplateWithResponseAsync(organization, project, templateId, body, context).block();
    }

    /**
     * Updates an existing build definition template.
     * 
     * @param organization The name of the Azure DevOps organization.
     * @param project Project ID or project name.
     * @param templateId The ID of the template.
     * @param body The new version of the template.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents a template from which new build definitions can be created.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public BuildDefinitionTemplateInner saveTemplate(String organization, String project, String templateId,
        BuildDefinitionTemplateInner body) {
        return saveTemplateWithResponse(organization, project, templateId, body, Context.NONE).getValue();
    }
}
