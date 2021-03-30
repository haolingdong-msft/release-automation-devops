// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.dev.fluent.models.LogInner;
import java.time.OffsetDateTime;

/** An immutable client-side representation of Log. */
public interface Log {
    /**
     * Gets the createdOn property: The date and time the log was created.
     *
     * @return the createdOn value.
     */
    OffsetDateTime createdOn();

    /**
     * Gets the id property: The ID of the log.
     *
     * @return the id value.
     */
    Integer id();

    /**
     * Gets the lastChangedOn property: The date and time the log was last changed.
     *
     * @return the lastChangedOn value.
     */
    OffsetDateTime lastChangedOn();

    /**
     * Gets the lineCount property: The number of lines in the log.
     *
     * @return the lineCount value.
     */
    Long lineCount();

    /**
     * Gets the signedContent property: A signed url allowing limited-time anonymous access to private resources.
     *
     * @return the signedContent value.
     */
    SignedUrl signedContent();

    /**
     * Gets the url property: The url property.
     *
     * @return the url value.
     */
    String url();

    /**
     * Gets the inner com.azure.dev.fluent.models.LogInner object.
     *
     * @return the inner object.
     */
    LogInner innerModel();
}
