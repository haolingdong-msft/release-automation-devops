// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.implementation;

import com.azure.dev.fluent.models.BuildCompletedEventInner;
import com.azure.dev.fluent.models.BuildInner;
import com.azure.dev.fluent.models.ChangeInner;
import com.azure.dev.fluent.models.PullRequestInner;
import com.azure.dev.models.AggregatedResultsAnalysis;
import com.azure.dev.models.AssociatedWorkItem;
import com.azure.dev.models.Build;
import com.azure.dev.models.BuildCompletedEvent;
import com.azure.dev.models.Change;
import com.azure.dev.models.PullRequest;
import com.azure.dev.models.TimelineRecord;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class BuildCompletedEventImpl implements BuildCompletedEvent {
    private BuildCompletedEventInner innerObject;

    private final com.azure.dev.DevManager serviceManager;

    BuildCompletedEventImpl(BuildCompletedEventInner innerObject, com.azure.dev.DevManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public Integer buildId() {
        return this.innerModel().buildId();
    }

    public Build build() {
        BuildInner inner = this.innerModel().build();
        if (inner != null) {
            return new BuildImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public List<Change> changes() {
        List<ChangeInner> inner = this.innerModel().changes();
        if (inner != null) {
            return Collections.unmodifiableList(
                inner.stream().map(inner1 -> new ChangeImpl(inner1, this.manager())).collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public PullRequest pullRequest() {
        PullRequestInner inner = this.innerModel().pullRequest();
        if (inner != null) {
            return new PullRequestImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public AggregatedResultsAnalysis testResults() {
        return this.innerModel().testResults();
    }

    public List<TimelineRecord> timelineRecords() {
        List<TimelineRecord> inner = this.innerModel().timelineRecords();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public List<AssociatedWorkItem> workItems() {
        List<AssociatedWorkItem> inner = this.innerModel().workItems();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public BuildCompletedEventInner innerModel() {
        return this.innerObject;
    }

    private com.azure.dev.DevManager manager() {
        return this.serviceManager;
    }
}
