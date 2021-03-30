// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;

/** The JustInTimeProcess model. */
@Immutable
public final class JustInTimeProcess extends BuildProcess {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(JustInTimeProcess.class);

    /** {@inheritDoc} */
    @Override
    public JustInTimeProcess withType(Integer type) {
        super.withType(type);
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
