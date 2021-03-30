// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Represents a build process supported by the build definition designer. */
@Fluent
public final class DesignerProcess extends BuildProcess {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DesignerProcess.class);

    /*
     * The phases property.
     */
    @JsonProperty(value = "phases")
    private List<Phase> phases;

    /*
     * The target for the build process.
     */
    @JsonProperty(value = "target")
    private DesignerProcessTarget target;

    /**
     * Get the phases property: The phases property.
     *
     * @return the phases value.
     */
    public List<Phase> phases() {
        return this.phases;
    }

    /**
     * Set the phases property: The phases property.
     *
     * @param phases the phases value to set.
     * @return the DesignerProcess object itself.
     */
    public DesignerProcess withPhases(List<Phase> phases) {
        this.phases = phases;
        return this;
    }

    /**
     * Get the target property: The target for the build process.
     *
     * @return the target value.
     */
    public DesignerProcessTarget target() {
        return this.target;
    }

    /**
     * Set the target property: The target for the build process.
     *
     * @param target the target value to set.
     * @return the DesignerProcess object itself.
     */
    public DesignerProcess withTarget(DesignerProcessTarget target) {
        this.target = target;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public DesignerProcess withType(Integer type) {
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
        if (phases() != null) {
            phases().forEach(e -> e.validate());
        }
        if (target() != null) {
            target().validate();
        }
    }
}
