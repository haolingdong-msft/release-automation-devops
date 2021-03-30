// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** Defines values for FolderQueryOrder. */
public enum FolderQueryOrder {
    /** Enum value none. */
    NONE("none"),

    /** Enum value folderAscending. */
    FOLDER_ASCENDING("folderAscending"),

    /** Enum value folderDescending. */
    FOLDER_DESCENDING("folderDescending");

    /** The actual serialized value for a FolderQueryOrder instance. */
    private final String value;

    FolderQueryOrder(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a FolderQueryOrder instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed FolderQueryOrder object, or null if unable to parse.
     */
    @JsonCreator
    public static FolderQueryOrder fromString(String value) {
        FolderQueryOrder[] items = FolderQueryOrder.values();
        for (FolderQueryOrder item : items) {
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
