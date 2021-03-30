// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.dev.fluent.models.PipelineInner;
import com.azure.dev.models.Pipeline;
import com.azure.dev.models.PipelineConfiguration;
import com.azure.dev.models.ReferenceLinks;

public final class PipelineImpl implements Pipeline {
    private PipelineInner innerObject;

    private final com.azure.dev.DevManager serviceManager;

    PipelineImpl(PipelineInner innerObject, com.azure.dev.DevManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String folder() {
        return this.innerModel().folder();
    }

    public Integer id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public Integer revision() {
        return this.innerModel().revision();
    }

    public ReferenceLinks links() {
        return this.innerModel().links();
    }

    public PipelineConfiguration configuration() {
        return this.innerModel().configuration();
    }

    public String url() {
        return this.innerModel().url();
    }

    public PipelineInner innerModel() {
        return this.innerObject;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
