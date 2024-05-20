// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for QueryDeletedOption.
 */
public enum QueryDeletedOption {
    /**
     * Enum value excludeDeleted.
     */
    EXCLUDE_DELETED("excludeDeleted"),

    /**
     * Enum value includeDeleted.
     */
    INCLUDE_DELETED("includeDeleted"),

    /**
     * Enum value onlyDeleted.
     */
    ONLY_DELETED("onlyDeleted");

    /**
     * The actual serialized value for a QueryDeletedOption instance.
     */
    private final String value;

    QueryDeletedOption(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a QueryDeletedOption instance.
     * 
     * @param value the serialized value to parse.
     * @return the parsed QueryDeletedOption object, or null if unable to parse.
     */
    @JsonCreator
    public static QueryDeletedOption fromString(String value) {
        if (value == null) {
            return null;
        }
        QueryDeletedOption[] items = QueryDeletedOption.values();
        for (QueryDeletedOption item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
