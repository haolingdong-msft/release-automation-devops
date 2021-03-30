// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents the result of validating a build request. */
@Fluent
public final class BuildRequestValidationResult {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(BuildRequestValidationResult.class);

    /*
     * The message associated with the result.
     */
    @JsonProperty(value = "message")
    private String message;

    /*
     * The result.
     */
    @JsonProperty(value = "result")
    private ValidationResult result;

    /**
     * Get the message property: The message associated with the result.
     *
     * @return the message value.
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message property: The message associated with the result.
     *
     * @param message the message value to set.
     * @return the BuildRequestValidationResult object itself.
     */
    public BuildRequestValidationResult withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the result property: The result.
     *
     * @return the result value.
     */
    public ValidationResult result() {
        return this.result;
    }

    /**
     * Set the result property: The result.
     *
     * @param result the result value to set.
     * @return the BuildRequestValidationResult object itself.
     */
    public BuildRequestValidationResult withResult(ValidationResult result) {
        this.result = result;
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
