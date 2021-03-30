// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.dev.fluent.models.ResourceRefInner;

/** An immutable client-side representation of ResourceRef. */
public interface ResourceRef {
    /**
     * Gets the id property: The id property.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the url property: The url property.
     *
     * @return the url value.
     */
    String url();

    /**
     * Gets the inner com.azure.dev.fluent.models.ResourceRefInner object.
     *
     * @return the inner object.
     */
    ResourceRefInner innerModel();
}
