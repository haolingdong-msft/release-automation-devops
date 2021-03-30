// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Represents a pull request trigger. */
@Fluent
public final class PullRequestTrigger extends BuildTrigger {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PullRequestTrigger.class);

    /*
     * Indicates if an update to a PR should delete current in-progress builds.
     */
    @JsonProperty(value = "autoCancel")
    private Boolean autoCancel;

    /*
     * The branchFilters property.
     */
    @JsonProperty(value = "branchFilters")
    private List<String> branchFilters;

    /*
     * Represents the ability to build forks of the selected repository.
     */
    @JsonProperty(value = "forks")
    private Forks forks;

    /*
     * The isCommentRequiredForPullRequest property.
     */
    @JsonProperty(value = "isCommentRequiredForPullRequest")
    private Boolean isCommentRequiredForPullRequest;

    /*
     * The pathFilters property.
     */
    @JsonProperty(value = "pathFilters")
    private List<String> pathFilters;

    /*
     * The requireCommentsForNonTeamMembersOnly property.
     */
    @JsonProperty(value = "requireCommentsForNonTeamMembersOnly")
    private Boolean requireCommentsForNonTeamMembersOnly;

    /*
     * The settingsSourceType property.
     */
    @JsonProperty(value = "settingsSourceType")
    private Integer settingsSourceType;

    /**
     * Get the autoCancel property: Indicates if an update to a PR should delete current in-progress builds.
     *
     * @return the autoCancel value.
     */
    public Boolean autoCancel() {
        return this.autoCancel;
    }

    /**
     * Set the autoCancel property: Indicates if an update to a PR should delete current in-progress builds.
     *
     * @param autoCancel the autoCancel value to set.
     * @return the PullRequestTrigger object itself.
     */
    public PullRequestTrigger withAutoCancel(Boolean autoCancel) {
        this.autoCancel = autoCancel;
        return this;
    }

    /**
     * Get the branchFilters property: The branchFilters property.
     *
     * @return the branchFilters value.
     */
    public List<String> branchFilters() {
        return this.branchFilters;
    }

    /**
     * Set the branchFilters property: The branchFilters property.
     *
     * @param branchFilters the branchFilters value to set.
     * @return the PullRequestTrigger object itself.
     */
    public PullRequestTrigger withBranchFilters(List<String> branchFilters) {
        this.branchFilters = branchFilters;
        return this;
    }

    /**
     * Get the forks property: Represents the ability to build forks of the selected repository.
     *
     * @return the forks value.
     */
    public Forks forks() {
        return this.forks;
    }

    /**
     * Set the forks property: Represents the ability to build forks of the selected repository.
     *
     * @param forks the forks value to set.
     * @return the PullRequestTrigger object itself.
     */
    public PullRequestTrigger withForks(Forks forks) {
        this.forks = forks;
        return this;
    }

    /**
     * Get the isCommentRequiredForPullRequest property: The isCommentRequiredForPullRequest property.
     *
     * @return the isCommentRequiredForPullRequest value.
     */
    public Boolean isCommentRequiredForPullRequest() {
        return this.isCommentRequiredForPullRequest;
    }

    /**
     * Set the isCommentRequiredForPullRequest property: The isCommentRequiredForPullRequest property.
     *
     * @param isCommentRequiredForPullRequest the isCommentRequiredForPullRequest value to set.
     * @return the PullRequestTrigger object itself.
     */
    public PullRequestTrigger withIsCommentRequiredForPullRequest(Boolean isCommentRequiredForPullRequest) {
        this.isCommentRequiredForPullRequest = isCommentRequiredForPullRequest;
        return this;
    }

    /**
     * Get the pathFilters property: The pathFilters property.
     *
     * @return the pathFilters value.
     */
    public List<String> pathFilters() {
        return this.pathFilters;
    }

    /**
     * Set the pathFilters property: The pathFilters property.
     *
     * @param pathFilters the pathFilters value to set.
     * @return the PullRequestTrigger object itself.
     */
    public PullRequestTrigger withPathFilters(List<String> pathFilters) {
        this.pathFilters = pathFilters;
        return this;
    }

    /**
     * Get the requireCommentsForNonTeamMembersOnly property: The requireCommentsForNonTeamMembersOnly property.
     *
     * @return the requireCommentsForNonTeamMembersOnly value.
     */
    public Boolean requireCommentsForNonTeamMembersOnly() {
        return this.requireCommentsForNonTeamMembersOnly;
    }

    /**
     * Set the requireCommentsForNonTeamMembersOnly property: The requireCommentsForNonTeamMembersOnly property.
     *
     * @param requireCommentsForNonTeamMembersOnly the requireCommentsForNonTeamMembersOnly value to set.
     * @return the PullRequestTrigger object itself.
     */
    public PullRequestTrigger withRequireCommentsForNonTeamMembersOnly(Boolean requireCommentsForNonTeamMembersOnly) {
        this.requireCommentsForNonTeamMembersOnly = requireCommentsForNonTeamMembersOnly;
        return this;
    }

    /**
     * Get the settingsSourceType property: The settingsSourceType property.
     *
     * @return the settingsSourceType value.
     */
    public Integer settingsSourceType() {
        return this.settingsSourceType;
    }

    /**
     * Set the settingsSourceType property: The settingsSourceType property.
     *
     * @param settingsSourceType the settingsSourceType value to set.
     * @return the PullRequestTrigger object itself.
     */
    public PullRequestTrigger withSettingsSourceType(Integer settingsSourceType) {
        this.settingsSourceType = settingsSourceType;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public PullRequestTrigger withTriggerType(DefinitionTriggerType triggerType) {
        super.withTriggerType(triggerType);
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
        if (forks() != null) {
            forks().validate();
        }
    }
}
