// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.fluent.models.BuildInner;
import com.azure.dev.fluent.models.BuildUpdatedEventInner;
import com.fasterxml.jackson.annotation.JsonIgnore;

/** The BuildQueuedEvent model. */
@Fluent
public final class BuildQueuedEvent extends BuildUpdatedEventInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(BuildQueuedEvent.class);

    /** {@inheritDoc} */
    @Override
    public BuildQueuedEvent withBuild(BuildInner build) {
        super.withBuild(build);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BuildQueuedEvent withBuildId(Integer buildId) {
        super.withBuildId(buildId);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
