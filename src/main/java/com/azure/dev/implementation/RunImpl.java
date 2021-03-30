// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.dev.fluent.models.RunInner;
import com.azure.dev.models.PipelineReference;
import com.azure.dev.models.ReferenceLinks;
import com.azure.dev.models.Run;
import com.azure.dev.models.RunResources;
import com.azure.dev.models.RunResult;
import com.azure.dev.models.RunState;
import com.azure.dev.models.Variable;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;

public final class RunImpl implements Run {
    private RunInner innerObject;

    private final com.azure.dev.DevManager serviceManager;

    RunImpl(RunInner innerObject, com.azure.dev.DevManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public Integer id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public ReferenceLinks links() {
        return this.innerModel().links();
    }

    public OffsetDateTime createdDate() {
        return this.innerModel().createdDate();
    }

    public String finalYaml() {
        return this.innerModel().finalYaml();
    }

    public OffsetDateTime finishedDate() {
        return this.innerModel().finishedDate();
    }

    public PipelineReference pipeline() {
        return this.innerModel().pipeline();
    }

    public RunResources resources() {
        return this.innerModel().resources();
    }

    public RunResult result() {
        return this.innerModel().result();
    }

    public RunState state() {
        return this.innerModel().state();
    }

    public String url() {
        return this.innerModel().url();
    }

    public Map<String, Variable> variables() {
        Map<String, Variable> inner = this.innerModel().variables();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public RunInner innerModel() {
        return this.innerObject;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
