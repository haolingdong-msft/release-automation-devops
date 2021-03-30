// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The XamlBuildControllerReference model. */
@Fluent
public class XamlBuildControllerReference {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(XamlBuildControllerReference.class);

    /*
     * Id of the resource
     */
    @JsonProperty(value = "id")
    private Integer id;

    /*
     * Name of the linked resource (definition name, controller name, etc.)
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Full http link to the resource
     */
    @JsonProperty(value = "url")
    private String url;

    /**
     * Get the id property: Id of the resource.
     *
     * @return the id value.
     */
    public Integer id() {
        return this.id;
    }

    /**
     * Set the id property: Id of the resource.
     *
     * @param id the id value to set.
     * @return the XamlBuildControllerReference object itself.
     */
    public XamlBuildControllerReference withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get the name property: Name of the linked resource (definition name, controller name, etc.).
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Name of the linked resource (definition name, controller name, etc.).
     *
     * @param name the name value to set.
     * @return the XamlBuildControllerReference object itself.
     */
    public XamlBuildControllerReference withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the url property: Full http link to the resource.
     *
     * @return the url value.
     */
    public String url() {
        return this.url;
    }

    /**
     * Set the url property: Full http link to the resource.
     *
     * @param url the url value to set.
     * @return the XamlBuildControllerReference object itself.
     */
    public XamlBuildControllerReference withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
