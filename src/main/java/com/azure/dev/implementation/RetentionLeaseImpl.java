// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.dev.fluent.models.RetentionLeaseInner;
import com.azure.dev.models.RetentionLease;
import java.time.OffsetDateTime;

public final class RetentionLeaseImpl implements RetentionLease {
    private RetentionLeaseInner innerObject;

    private final com.azure.dev.DevManager serviceManager;

    RetentionLeaseImpl(RetentionLeaseInner innerObject, com.azure.dev.DevManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public OffsetDateTime createdOn() {
        return this.innerModel().createdOn();
    }

    public Integer definitionId() {
        return this.innerModel().definitionId();
    }

    public Integer leaseId() {
        return this.innerModel().leaseId();
    }

    public String ownerId() {
        return this.innerModel().ownerId();
    }

    public Boolean protectPipeline() {
        return this.innerModel().protectPipeline();
    }

    public Integer runId() {
        return this.innerModel().runId();
    }

    public OffsetDateTime validUntil() {
        return this.innerModel().validUntil();
    }

    public RetentionLeaseInner innerModel() {
        return this.innerObject;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
