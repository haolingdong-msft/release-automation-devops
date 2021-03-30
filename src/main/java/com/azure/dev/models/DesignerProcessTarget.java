// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents the target for the build process. */
@Fluent
public class DesignerProcessTarget {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DesignerProcessTarget.class);

    /*
     * Agent specification for the build process.
     */
    @JsonProperty(value = "agentSpecification")
    private AgentSpecification agentSpecification;

    /**
     * Get the agentSpecification property: Agent specification for the build process.
     *
     * @return the agentSpecification value.
     */
    public AgentSpecification agentSpecification() {
        return this.agentSpecification;
    }

    /**
     * Set the agentSpecification property: Agent specification for the build process.
     *
     * @param agentSpecification the agentSpecification value to set.
     * @return the DesignerProcessTarget object itself.
     */
    public DesignerProcessTarget withAgentSpecification(AgentSpecification agentSpecification) {
        this.agentSpecification = agentSpecification;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (agentSpecification() != null) {
            agentSpecification().validate();
        }
    }
}
