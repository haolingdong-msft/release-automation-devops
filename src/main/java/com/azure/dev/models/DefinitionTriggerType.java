// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Defines values for DefinitionTriggerType. */
public enum DefinitionTriggerType {
    /** Enum value none. */
    NONE("none"),

    /** Enum value continuousIntegration. */
    CONTINUOUS_INTEGRATION("continuousIntegration"),

    /** Enum value batchedContinuousIntegration. */
    BATCHED_CONTINUOUS_INTEGRATION("batchedContinuousIntegration"),

    /** Enum value schedule. */
    SCHEDULE("schedule"),

    /** Enum value gatedCheckIn. */
    GATED_CHECK_IN("gatedCheckIn"),

    /** Enum value batchedGatedCheckIn. */
    BATCHED_GATED_CHECK_IN("batchedGatedCheckIn"),

    /** Enum value pullRequest. */
    PULL_REQUEST("pullRequest"),

    /** Enum value buildCompletion. */
    BUILD_COMPLETION("buildCompletion"),

    /** Enum value all. */
    ALL("all");

    /** The actual serialized value for a DefinitionTriggerType instance. */
    private final String value;

    DefinitionTriggerType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a DefinitionTriggerType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed DefinitionTriggerType object, or null if unable to parse.
     */
    @JsonCreator
    public static DefinitionTriggerType fromString(String value) {
        DefinitionTriggerType[] items = DefinitionTriggerType.values();
        for (DefinitionTriggerType item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
