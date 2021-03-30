// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The UpdateStageParameters model. */
@Fluent
public final class UpdateStageParameters {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(UpdateStageParameters.class);

    /*
     * The state property.
     */
    @JsonProperty(value = "state")
    private StageUpdateType state;

    /**
     * Get the state property: The state property.
     *
     * @return the state value.
     */
    public StageUpdateType state() {
        return this.state;
    }

    /**
     * Set the state property: The state property.
     *
     * @param state the state value to set.
     * @return the UpdateStageParameters object itself.
     */
    public UpdateStageParameters withState(StageUpdateType state) {
        this.state = state;
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
