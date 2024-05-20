// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.dev.models.BuildOptionDefinitionReference;
import com.azure.dev.models.BuildOptionGroupDefinition;
import com.azure.dev.models.BuildOptionInputDefinition;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.UUID;

/**
 * Represents an optional behavior that can be applied to a build definition.
 */
@Fluent
public final class BuildOptionDefinitionInner extends BuildOptionDefinitionReference {
    /*
     * The description.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * The list of input groups defined for the build option.
     */
    @JsonProperty(value = "groups")
    private List<BuildOptionGroupDefinition> groups;

    /*
     * The list of inputs defined for the build option.
     */
    @JsonProperty(value = "inputs")
    private List<BuildOptionInputDefinition> inputs;

    /*
     * The name of the build option.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * A value that indicates the relative order in which the behavior should be applied.
     */
    @JsonProperty(value = "ordinal")
    private Integer ordinal;

    /**
     * Creates an instance of BuildOptionDefinitionInner class.
     */
    public BuildOptionDefinitionInner() {
    }

    /**
     * Get the description property: The description.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The description.
     * 
     * @param description the description value to set.
     * @return the BuildOptionDefinitionInner object itself.
     */
    public BuildOptionDefinitionInner withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the groups property: The list of input groups defined for the build option.
     * 
     * @return the groups value.
     */
    public List<BuildOptionGroupDefinition> groups() {
        return this.groups;
    }

    /**
     * Set the groups property: The list of input groups defined for the build option.
     * 
     * @param groups the groups value to set.
     * @return the BuildOptionDefinitionInner object itself.
     */
    public BuildOptionDefinitionInner withGroups(List<BuildOptionGroupDefinition> groups) {
        this.groups = groups;
        return this;
    }

    /**
     * Get the inputs property: The list of inputs defined for the build option.
     * 
     * @return the inputs value.
     */
    public List<BuildOptionInputDefinition> inputs() {
        return this.inputs;
    }

    /**
     * Set the inputs property: The list of inputs defined for the build option.
     * 
     * @param inputs the inputs value to set.
     * @return the BuildOptionDefinitionInner object itself.
     */
    public BuildOptionDefinitionInner withInputs(List<BuildOptionInputDefinition> inputs) {
        this.inputs = inputs;
        return this;
    }

    /**
     * Get the name property: The name of the build option.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the build option.
     * 
     * @param name the name value to set.
     * @return the BuildOptionDefinitionInner object itself.
     */
    public BuildOptionDefinitionInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the ordinal property: A value that indicates the relative order in which the behavior should be applied.
     * 
     * @return the ordinal value.
     */
    public Integer ordinal() {
        return this.ordinal;
    }

    /**
     * Set the ordinal property: A value that indicates the relative order in which the behavior should be applied.
     * 
     * @param ordinal the ordinal value to set.
     * @return the BuildOptionDefinitionInner object itself.
     */
    public BuildOptionDefinitionInner withOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BuildOptionDefinitionInner withId(UUID id) {
        super.withId(id);
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
        if (groups() != null) {
            groups().forEach(e -> e.validate());
        }
        if (inputs() != null) {
            inputs().forEach(e -> e.validate());
        }
    }
}
