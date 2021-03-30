// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.dev.fluent.models.BuildReportMetadataInner;
import com.azure.dev.models.BuildReportMetadata;

public final class BuildReportMetadataImpl implements BuildReportMetadata {
    private BuildReportMetadataInner innerObject;

    private final com.azure.dev.DevManager serviceManager;

    BuildReportMetadataImpl(BuildReportMetadataInner innerObject, com.azure.dev.DevManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public Integer buildId() {
        return this.innerModel().buildId();
    }

    public String content() {
        return this.innerModel().content();
    }

    public String type() {
        return this.innerModel().type();
    }

    public BuildReportMetadataInner innerModel() {
        return this.innerObject;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
