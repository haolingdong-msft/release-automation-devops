// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Represents a YAML process. */
@Fluent
public final class YamlProcess extends BuildProcess {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(YamlProcess.class);

    /*
     * The errors property.
     */
    @JsonProperty(value = "errors")
    private List<String> errors;

    /*
     * The resources used by the build definition.
     */
    @JsonProperty(value = "resources")
    private BuildProcessResources resources;

    /*
     * The YAML filename.
     */
    @JsonProperty(value = "yamlFilename")
    private String yamlFilename;

    /**
     * Get the errors property: The errors property.
     *
     * @return the errors value.
     */
    public List<String> errors() {
        return this.errors;
    }

    /**
     * Set the errors property: The errors property.
     *
     * @param errors the errors value to set.
     * @return the YamlProcess object itself.
     */
    public YamlProcess withErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    /**
     * Get the resources property: The resources used by the build definition.
     *
     * @return the resources value.
     */
    public BuildProcessResources resources() {
        return this.resources;
    }

    /**
     * Set the resources property: The resources used by the build definition.
     *
     * @param resources the resources value to set.
     * @return the YamlProcess object itself.
     */
    public YamlProcess withResources(BuildProcessResources resources) {
        this.resources = resources;
        return this;
    }

    /**
     * Get the yamlFilename property: The YAML filename.
     *
     * @return the yamlFilename value.
     */
    public String yamlFilename() {
        return this.yamlFilename;
    }

    /**
     * Set the yamlFilename property: The YAML filename.
     *
     * @param yamlFilename the yamlFilename value to set.
     * @return the YamlProcess object itself.
     */
    public YamlProcess withYamlFilename(String yamlFilename) {
        this.yamlFilename = yamlFilename;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public YamlProcess withType(Integer type) {
        super.withType(type);
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
        if (resources() != null) {
            resources().validate();
        }
    }
}
