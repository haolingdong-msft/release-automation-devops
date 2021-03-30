// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.models.AggregatedResultsAnalysis;
import com.azure.dev.models.AssociatedWorkItem;
import com.azure.dev.models.TimelineRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The BuildCompletedEvent model. */
@Fluent
public final class BuildCompletedEventInner extends BuildUpdatedEventInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(BuildCompletedEventInner.class);

    /*
     * Changes associated with a build used for build notifications
     */
    @JsonProperty(value = "changes")
    private List<ChangeInner> changes;

    /*
     * Pull request for the build used for build notifications
     */
    @JsonProperty(value = "pullRequest")
    private PullRequestInner pullRequest;

    /*
     * Test results associated with a build used for build notifications
     */
    @JsonProperty(value = "testResults")
    private AggregatedResultsAnalysis testResults;

    /*
     * Timeline records associated with a build used for build notifications
     */
    @JsonProperty(value = "timelineRecords")
    private List<TimelineRecord> timelineRecords;

    /*
     * Work items associated with a build used for build notifications
     */
    @JsonProperty(value = "workItems")
    private List<AssociatedWorkItem> workItems;

    /**
     * Get the changes property: Changes associated with a build used for build notifications.
     *
     * @return the changes value.
     */
    public List<ChangeInner> changes() {
        return this.changes;
    }

    /**
     * Set the changes property: Changes associated with a build used for build notifications.
     *
     * @param changes the changes value to set.
     * @return the BuildCompletedEventInner object itself.
     */
    public BuildCompletedEventInner withChanges(List<ChangeInner> changes) {
        this.changes = changes;
        return this;
    }

    /**
     * Get the pullRequest property: Pull request for the build used for build notifications.
     *
     * @return the pullRequest value.
     */
    public PullRequestInner pullRequest() {
        return this.pullRequest;
    }

    /**
     * Set the pullRequest property: Pull request for the build used for build notifications.
     *
     * @param pullRequest the pullRequest value to set.
     * @return the BuildCompletedEventInner object itself.
     */
    public BuildCompletedEventInner withPullRequest(PullRequestInner pullRequest) {
        this.pullRequest = pullRequest;
        return this;
    }

    /**
     * Get the testResults property: Test results associated with a build used for build notifications.
     *
     * @return the testResults value.
     */
    public AggregatedResultsAnalysis testResults() {
        return this.testResults;
    }

    /**
     * Set the testResults property: Test results associated with a build used for build notifications.
     *
     * @param testResults the testResults value to set.
     * @return the BuildCompletedEventInner object itself.
     */
    public BuildCompletedEventInner withTestResults(AggregatedResultsAnalysis testResults) {
        this.testResults = testResults;
        return this;
    }

    /**
     * Get the timelineRecords property: Timeline records associated with a build used for build notifications.
     *
     * @return the timelineRecords value.
     */
    public List<TimelineRecord> timelineRecords() {
        return this.timelineRecords;
    }

    /**
     * Set the timelineRecords property: Timeline records associated with a build used for build notifications.
     *
     * @param timelineRecords the timelineRecords value to set.
     * @return the BuildCompletedEventInner object itself.
     */
    public BuildCompletedEventInner withTimelineRecords(List<TimelineRecord> timelineRecords) {
        this.timelineRecords = timelineRecords;
        return this;
    }

    /**
     * Get the workItems property: Work items associated with a build used for build notifications.
     *
     * @return the workItems value.
     */
    public List<AssociatedWorkItem> workItems() {
        return this.workItems;
    }

    /**
     * Set the workItems property: Work items associated with a build used for build notifications.
     *
     * @param workItems the workItems value to set.
     * @return the BuildCompletedEventInner object itself.
     */
    public BuildCompletedEventInner withWorkItems(List<AssociatedWorkItem> workItems) {
        this.workItems = workItems;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BuildCompletedEventInner withBuild(BuildInner build) {
        super.withBuild(build);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public BuildCompletedEventInner withBuildId(Integer buildId) {
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
        if (changes() != null) {
            changes().forEach(e -> e.validate());
        }
        if (pullRequest() != null) {
            pullRequest().validate();
        }
        if (testResults() != null) {
            testResults().validate();
        }
        if (timelineRecords() != null) {
            timelineRecords().forEach(e -> e.validate());
        }
        if (workItems() != null) {
            workItems().forEach(e -> e.validate());
        }
    }
}
