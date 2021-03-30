// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Phase in pipeline. */
@Fluent
public final class PhaseReference {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PhaseReference.class);

    /*
     * Attempt number of the phase
     */
    @JsonProperty(value = "attempt")
    private Integer attempt;

    /*
     * Name of the phase. Maximum supported length for name is 256 character.
     */
    @JsonProperty(value = "phaseName")
    private String phaseName;

    /**
     * Get the attempt property: Attempt number of the phase.
     *
     * @return the attempt value.
     */
    public Integer attempt() {
        return this.attempt;
    }

    /**
     * Set the attempt property: Attempt number of the phase.
     *
     * @param attempt the attempt value to set.
     * @return the PhaseReference object itself.
     */
    public PhaseReference withAttempt(Integer attempt) {
        this.attempt = attempt;
        return this;
    }

    /**
     * Get the phaseName property: Name of the phase. Maximum supported length for name is 256 character.
     *
     * @return the phaseName value.
     */
    public String phaseName() {
        return this.phaseName;
    }

    /**
     * Set the phaseName property: Name of the phase. Maximum supported length for name is 256 character.
     *
     * @param phaseName the phaseName value to set.
     * @return the PhaseReference object itself.
     */
    public PhaseReference withPhaseName(String phaseName) {
        this.phaseName = phaseName;
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
