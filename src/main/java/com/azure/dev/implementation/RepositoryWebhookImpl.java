// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.dev.fluent.models.RepositoryWebhookInner;
import com.azure.dev.models.DefinitionTriggerType;
import com.azure.dev.models.RepositoryWebhook;
import java.util.Collections;
import java.util.List;

public final class RepositoryWebhookImpl implements RepositoryWebhook {
    private RepositoryWebhookInner innerObject;

    private final com.azure.dev.DevManager serviceManager;

    RepositoryWebhookImpl(RepositoryWebhookInner innerObject, com.azure.dev.DevManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String name() {
        return this.innerModel().name();
    }

    public List<DefinitionTriggerType> types() {
        List<DefinitionTriggerType> inner = this.innerModel().types();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String url() {
        return this.innerModel().url();
    }

    public RepositoryWebhookInner innerModel() {
        return this.innerObject;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
