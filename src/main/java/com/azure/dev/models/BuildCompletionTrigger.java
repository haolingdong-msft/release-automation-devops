// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a build completion trigger.
 */
@Fluent
public final class BuildCompletionTrigger extends BuildTrigger {
    /*
     * The branchFilters property.
     */
    @JsonProperty(value = "branchFilters")
    private List<String> branchFilters;

    /*
     * A reference to the definition that should trigger builds for this definition.
     */
    @JsonProperty(value = "definition")
    private DefinitionReference definition;

    /*
     * The requiresSuccessfulBuild property.
     */
    @JsonProperty(value = "requiresSuccessfulBuild")
    private Boolean requiresSuccessfulBuild;

    /**
     * Creates an instance of BuildCompletionTrigger class.
     */
    public BuildCompletionTrigger() {
    }

    /**
     * Get the branchFilters property: The branchFilters property.
     * 
     * @return the branchFilters value.
     */
    public List<String> branchFilters() {
        return this.branchFilters;
    }

    /**
     * Set the branchFilters property: The branchFilters property.
     * 
     * @param branchFilters the branchFilters value to set.
     * @return the BuildCompletionTrigger object itself.
     */
    public BuildCompletionTrigger withBranchFilters(List<String> branchFilters) {
        this.branchFilters = branchFilters;
        return this;
    }

    /**
     * Get the definition property: A reference to the definition that should trigger builds for this definition.
     * 
     * @return the definition value.
     */
    public DefinitionReference definition() {
        return this.definition;
    }

    /**
     * Set the definition property: A reference to the definition that should trigger builds for this definition.
     * 
     * @param definition the definition value to set.
     * @return the BuildCompletionTrigger object itself.
     */
    public BuildCompletionTrigger withDefinition(DefinitionReference definition) {
        this.definition = definition;
        return this;
    }

    /**
     * Get the requiresSuccessfulBuild property: The requiresSuccessfulBuild property.
     * 
     * @return the requiresSuccessfulBuild value.
     */
    public Boolean requiresSuccessfulBuild() {
        return this.requiresSuccessfulBuild;
    }

    /**
     * Set the requiresSuccessfulBuild property: The requiresSuccessfulBuild property.
     * 
     * @param requiresSuccessfulBuild the requiresSuccessfulBuild value to set.
     * @return the BuildCompletionTrigger object itself.
     */
    public BuildCompletionTrigger withRequiresSuccessfulBuild(Boolean requiresSuccessfulBuild) {
        this.requiresSuccessfulBuild = requiresSuccessfulBuild;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BuildCompletionTrigger withTriggerType(DefinitionTriggerType triggerType) {
        super.withTriggerType(triggerType);
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
        if (definition() != null) {
            definition().validate();
        }
    }
}
