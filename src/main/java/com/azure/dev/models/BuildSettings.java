// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.dev.fluent.models.BuildSettingsInner;

/** An immutable client-side representation of BuildSettings. */
public interface BuildSettings {
    /**
     * Gets the daysToKeepDeletedBuildsBeforeDestroy property: The number of days to keep records of deleted builds.
     *
     * @return the daysToKeepDeletedBuildsBeforeDestroy value.
     */
    Integer daysToKeepDeletedBuildsBeforeDestroy();

    /**
     * Gets the defaultRetentionPolicy property: The default retention policy.
     *
     * @return the defaultRetentionPolicy value.
     */
    RetentionPolicy defaultRetentionPolicy();

    /**
     * Gets the maximumRetentionPolicy property: The maximum retention policy.
     *
     * @return the maximumRetentionPolicy value.
     */
    RetentionPolicy maximumRetentionPolicy();

    /**
     * Gets the inner com.azure.dev.fluent.models.BuildSettingsInner object.
     *
     * @return the inner object.
     */
    BuildSettingsInner innerModel();
}
