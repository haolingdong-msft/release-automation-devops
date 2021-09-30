// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** Represents a variable group. */
@Fluent
public final class VariableGroup extends VariableGroupReference {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(VariableGroup.class);

    /*
     * The description.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * The name of the variable group.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * The type of the variable group.
     */
    @JsonProperty(value = "type")
    private String type;

    /*
     * Dictionary of <BuildDefinitionVariable>
     */
    @JsonProperty(value = "variables")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, BuildDefinitionVariable> variables;

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
     * @return the VariableGroup object itself.
     */
    public VariableGroup withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the name property: The name of the variable group.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the variable group.
     *
     * @param name the name value to set.
     * @return the VariableGroup object itself.
     */
    public VariableGroup withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the type property: The type of the variable group.
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type property: The type of the variable group.
     *
     * @param type the type value to set.
     * @return the VariableGroup object itself.
     */
    public VariableGroup withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the variables property: Dictionary of &lt;BuildDefinitionVariable&gt;.
     *
     * @return the variables value.
     */
    public Map<String, BuildDefinitionVariable> variables() {
        return this.variables;
    }

    /**
     * Set the variables property: Dictionary of &lt;BuildDefinitionVariable&gt;.
     *
     * @param variables the variables value to set.
     * @return the VariableGroup object itself.
     */
    public VariableGroup withVariables(Map<String, BuildDefinitionVariable> variables) {
        this.variables = variables;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public VariableGroup withAlias(String alias) {
        super.withAlias(alias);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public VariableGroup withId(Integer id) {
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
        if (variables() != null) {
            variables()
                .values()
                .forEach(
                    e -> {
                        if (e != null) {
                            e.validate();
                        }
                    });
        }
    }
}
