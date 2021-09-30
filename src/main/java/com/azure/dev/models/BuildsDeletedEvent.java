// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.UUID;

/** The BuildsDeletedEvent model. */
@Fluent
public final class BuildsDeletedEvent extends BuildsDeletedEvent1 {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(BuildsDeletedEvent.class);

    /** {@inheritDoc} */
    @Override
    public BuildsDeletedEvent withBuildIds(List<Integer> buildIds) {
        super.withBuildIds(buildIds);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BuildsDeletedEvent withDefinitionId(Integer definitionId) {
        super.withDefinitionId(definitionId);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BuildsDeletedEvent withProjectId(UUID projectId) {
        super.withProjectId(projectId);
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
