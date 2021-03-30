// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.dev.fluent.models.DefinitionResourceReferenceInner;
import com.azure.dev.models.DefinitionResourceReference;

public final class DefinitionResourceReferenceImpl implements DefinitionResourceReference {
    private DefinitionResourceReferenceInner innerObject;

    private final com.azure.dev.DevManager serviceManager;

    DefinitionResourceReferenceImpl(
        DefinitionResourceReferenceInner innerObject, com.azure.dev.DevManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public Boolean authorized() {
        return this.innerModel().authorized();
    }

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public DefinitionResourceReferenceInner innerModel() {
        return this.innerObject;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
