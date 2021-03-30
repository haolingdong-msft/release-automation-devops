// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Defines values for BuildStatus. */
public enum BuildStatus {
    /** Enum value none. */
    NONE("none"),

    /** Enum value inProgress. */
    IN_PROGRESS("inProgress"),

    /** Enum value completed. */
    COMPLETED("completed"),

    /** Enum value cancelling. */
    CANCELLING("cancelling"),

    /** Enum value postponed. */
    POSTPONED("postponed"),

    /** Enum value notStarted. */
    NOT_STARTED("notStarted"),

    /** Enum value all. */
    ALL("all");

    /** The actual serialized value for a BuildStatus instance. */
    private final String value;

    BuildStatus(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a BuildStatus instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed BuildStatus object, or null if unable to parse.
     */
    @JsonCreator
    public static BuildStatus fromString(String value) {
        BuildStatus[] items = BuildStatus.values();
        for (BuildStatus item : items) {
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
