// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** Represents a phase of a build definition. */
@Fluent
public final class Phase {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(Phase.class);

    /*
     * The condition that must be true for this phase to execute.
     */
    @JsonProperty(value = "condition")
    private String condition;

    /*
     * The dependencies property.
     */
    @JsonProperty(value = "dependencies")
    private List<Dependency> dependencies;

    /*
     * The job authorization scope for builds queued against this definition.
     */
    @JsonProperty(value = "jobAuthorizationScope")
    private BuildAuthorizationScope jobAuthorizationScope;

    /*
     * The cancellation timeout, in minutes, for builds queued against this
     * definition.
     */
    @JsonProperty(value = "jobCancelTimeoutInMinutes")
    private Integer jobCancelTimeoutInMinutes;

    /*
     * The job execution timeout, in minutes, for builds queued against this
     * definition.
     */
    @JsonProperty(value = "jobTimeoutInMinutes")
    private Integer jobTimeoutInMinutes;

    /*
     * The name of the phase.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * The unique ref name of the phase.
     */
    @JsonProperty(value = "refName")
    private String refName;

    /*
     * The steps property.
     */
    @JsonProperty(value = "steps")
    private List<BuildDefinitionStep> steps;

    /*
     * The target (agent, server, etc.) for this phase.
     */
    @JsonProperty(value = "target")
    private PhaseTarget target;

    /*
     * Dictionary of <BuildDefinitionVariable>
     */
    @JsonProperty(value = "variables")
    private Map<String, BuildDefinitionVariable> variables;

    /**
     * Get the condition property: The condition that must be true for this phase to execute.
     *
     * @return the condition value.
     */
    public String condition() {
        return this.condition;
    }

    /**
     * Set the condition property: The condition that must be true for this phase to execute.
     *
     * @param condition the condition value to set.
     * @return the Phase object itself.
     */
    public Phase withCondition(String condition) {
        this.condition = condition;
        return this;
    }

    /**
     * Get the dependencies property: The dependencies property.
     *
     * @return the dependencies value.
     */
    public List<Dependency> dependencies() {
        return this.dependencies;
    }

    /**
     * Set the dependencies property: The dependencies property.
     *
     * @param dependencies the dependencies value to set.
     * @return the Phase object itself.
     */
    public Phase withDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
        return this;
    }

    /**
     * Get the jobAuthorizationScope property: The job authorization scope for builds queued against this definition.
     *
     * @return the jobAuthorizationScope value.
     */
    public BuildAuthorizationScope jobAuthorizationScope() {
        return this.jobAuthorizationScope;
    }

    /**
     * Set the jobAuthorizationScope property: The job authorization scope for builds queued against this definition.
     *
     * @param jobAuthorizationScope the jobAuthorizationScope value to set.
     * @return the Phase object itself.
     */
    public Phase withJobAuthorizationScope(BuildAuthorizationScope jobAuthorizationScope) {
        this.jobAuthorizationScope = jobAuthorizationScope;
        return this;
    }

    /**
     * Get the jobCancelTimeoutInMinutes property: The cancellation timeout, in minutes, for builds queued against this
     * definition.
     *
     * @return the jobCancelTimeoutInMinutes value.
     */
    public Integer jobCancelTimeoutInMinutes() {
        return this.jobCancelTimeoutInMinutes;
    }

    /**
     * Set the jobCancelTimeoutInMinutes property: The cancellation timeout, in minutes, for builds queued against this
     * definition.
     *
     * @param jobCancelTimeoutInMinutes the jobCancelTimeoutInMinutes value to set.
     * @return the Phase object itself.
     */
    public Phase withJobCancelTimeoutInMinutes(Integer jobCancelTimeoutInMinutes) {
        this.jobCancelTimeoutInMinutes = jobCancelTimeoutInMinutes;
        return this;
    }

    /**
     * Get the jobTimeoutInMinutes property: The job execution timeout, in minutes, for builds queued against this
     * definition.
     *
     * @return the jobTimeoutInMinutes value.
     */
    public Integer jobTimeoutInMinutes() {
        return this.jobTimeoutInMinutes;
    }

    /**
     * Set the jobTimeoutInMinutes property: The job execution timeout, in minutes, for builds queued against this
     * definition.
     *
     * @param jobTimeoutInMinutes the jobTimeoutInMinutes value to set.
     * @return the Phase object itself.
     */
    public Phase withJobTimeoutInMinutes(Integer jobTimeoutInMinutes) {
        this.jobTimeoutInMinutes = jobTimeoutInMinutes;
        return this;
    }

    /**
     * Get the name property: The name of the phase.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the phase.
     *
     * @param name the name value to set.
     * @return the Phase object itself.
     */
    public Phase withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the refName property: The unique ref name of the phase.
     *
     * @return the refName value.
     */
    public String refName() {
        return this.refName;
    }

    /**
     * Set the refName property: The unique ref name of the phase.
     *
     * @param refName the refName value to set.
     * @return the Phase object itself.
     */
    public Phase withRefName(String refName) {
        this.refName = refName;
        return this;
    }

    /**
     * Get the steps property: The steps property.
     *
     * @return the steps value.
     */
    public List<BuildDefinitionStep> steps() {
        return this.steps;
    }

    /**
     * Set the steps property: The steps property.
     *
     * @param steps the steps value to set.
     * @return the Phase object itself.
     */
    public Phase withSteps(List<BuildDefinitionStep> steps) {
        this.steps = steps;
        return this;
    }

    /**
     * Get the target property: The target (agent, server, etc.) for this phase.
     *
     * @return the target value.
     */
    public PhaseTarget target() {
        return this.target;
    }

    /**
     * Set the target property: The target (agent, server, etc.) for this phase.
     *
     * @param target the target value to set.
     * @return the Phase object itself.
     */
    public Phase withTarget(PhaseTarget target) {
        this.target = target;
        return this;
    }

    /**
     * Get the variables property: Dictionary of &lt;BuildDefinitionVariable&gt;.
     *
     * @return the variables value.
     */
    public Map<String, BuildDefinitionVariable> variables() {
        return this.variables;
    }

    /**
     * Set the variables property: Dictionary of &lt;BuildDefinitionVariable&gt;.
     *
     * @param variables the variables value to set.
     * @return the Phase object itself.
     */
    public Phase withVariables(Map<String, BuildDefinitionVariable> variables) {
        this.variables = variables;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (dependencies() != null) {
            dependencies().forEach(e -> e.validate());
        }
        if (steps() != null) {
            steps().forEach(e -> e.validate());
        }
        if (target() != null) {
            target().validate();
        }
        if (variables() != null) {
            variables()
                .values()
                .forEach(
                    e -> {
                        if (e != null) {
                            e.validate();
                        }
                    });
        }
    }
}
