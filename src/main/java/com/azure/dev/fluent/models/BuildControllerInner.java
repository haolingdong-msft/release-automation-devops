// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.models.ControllerStatus;
import com.azure.dev.models.ReferenceLinks;
import com.azure.dev.models.XamlBuildControllerReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The BuildController model. */
@Fluent
public final class BuildControllerInner extends XamlBuildControllerReference {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(BuildControllerInner.class);

    /*
     * The class to represent a collection of REST reference links.
     */
    @JsonProperty(value = "_links")
    private ReferenceLinks links;

    /*
     * The date the controller was created.
     */
    @JsonProperty(value = "createdDate")
    private OffsetDateTime createdDate;

    /*
     * The description of the controller.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * Indicates whether the controller is enabled.
     */
    @JsonProperty(value = "enabled")
    private Boolean enabled;

    /*
     * The status of the controller.
     */
    @JsonProperty(value = "status")
    private ControllerStatus status;

    /*
     * The date the controller was last updated.
     */
    @JsonProperty(value = "updatedDate")
    private OffsetDateTime updatedDate;

    /*
     * The controller's URI.
     */
    @JsonProperty(value = "uri")
    private String uri;

    /**
     * Get the links property: The class to represent a collection of REST reference links.
     *
     * @return the links value.
     */
    public ReferenceLinks links() {
        return this.links;
    }

    /**
     * Set the links property: The class to represent a collection of REST reference links.
     *
     * @param links the links value to set.
     * @return the BuildControllerInner object itself.
     */
    public BuildControllerInner withLinks(ReferenceLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get the createdDate property: The date the controller was created.
     *
     * @return the createdDate value.
     */
    public OffsetDateTime createdDate() {
        return this.createdDate;
    }

    /**
     * Set the createdDate property: The date the controller was created.
     *
     * @param createdDate the createdDate value to set.
     * @return the BuildControllerInner object itself.
     */
    public BuildControllerInner withCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Get the description property: The description of the controller.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The description of the controller.
     *
     * @param description the description value to set.
     * @return the BuildControllerInner object itself.
     */
    public BuildControllerInner withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the enabled property: Indicates whether the controller is enabled.
     *
     * @return the enabled value.
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Indicates whether the controller is enabled.
     *
     * @param enabled the enabled value to set.
     * @return the BuildControllerInner object itself.
     */
    public BuildControllerInner withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the status property: The status of the controller.
     *
     * @return the status value.
     */
    public ControllerStatus status() {
        return this.status;
    }

    /**
     * Set the status property: The status of the controller.
     *
     * @param status the status value to set.
     * @return the BuildControllerInner object itself.
     */
    public BuildControllerInner withStatus(ControllerStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get the updatedDate property: The date the controller was last updated.
     *
     * @return the updatedDate value.
     */
    public OffsetDateTime updatedDate() {
        return this.updatedDate;
    }

    /**
     * Set the updatedDate property: The date the controller was last updated.
     *
     * @param updatedDate the updatedDate value to set.
     * @return the BuildControllerInner object itself.
     */
    public BuildControllerInner withUpdatedDate(OffsetDateTime updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    /**
     * Get the uri property: The controller's URI.
     *
     * @return the uri value.
     */
    public String uri() {
        return this.uri;
    }

    /**
     * Set the uri property: The controller's URI.
     *
     * @param uri the uri value to set.
     * @return the BuildControllerInner object itself.
     */
    public BuildControllerInner withUri(String uri) {
        this.uri = uri;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BuildControllerInner withId(Integer id) {
        super.withId(id);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BuildControllerInner withName(String name) {
        super.withName(name);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BuildControllerInner withUrl(String url) {
        super.withUrl(url);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (links() != null) {
            links().validate();
        }
    }
}
