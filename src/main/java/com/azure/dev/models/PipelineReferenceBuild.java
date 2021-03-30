// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Pipeline reference. */
@Fluent
public final class PipelineReferenceBuild {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PipelineReferenceBuild.class);

    /*
     * Reference of the job
     */
    @JsonProperty(value = "jobReference")
    private JobReference jobReference;

    /*
     * Reference of the phase.
     */
    @JsonProperty(value = "phaseReference")
    private PhaseReference phaseReference;

    /*
     * Reference of the pipeline with which this pipeline instance is related.
     */
    @JsonProperty(value = "pipelineId")
    private Integer pipelineId;

    /*
     * Reference of the stage.
     */
    @JsonProperty(value = "stageReference")
    private StageReference stageReference;

    /**
     * Get the jobReference property: Reference of the job.
     *
     * @return the jobReference value.
     */
    public JobReference jobReference() {
        return this.jobReference;
    }

    /**
     * Set the jobReference property: Reference of the job.
     *
     * @param jobReference the jobReference value to set.
     * @return the PipelineReferenceBuild object itself.
     */
    public PipelineReferenceBuild withJobReference(JobReference jobReference) {
        this.jobReference = jobReference;
        return this;
    }

    /**
     * Get the phaseReference property: Reference of the phase.
     *
     * @return the phaseReference value.
     */
    public PhaseReference phaseReference() {
        return this.phaseReference;
    }

    /**
     * Set the phaseReference property: Reference of the phase.
     *
     * @param phaseReference the phaseReference value to set.
     * @return the PipelineReferenceBuild object itself.
     */
    public PipelineReferenceBuild withPhaseReference(PhaseReference phaseReference) {
        this.phaseReference = phaseReference;
        return this;
    }

    /**
     * Get the pipelineId property: Reference of the pipeline with which this pipeline instance is related.
     *
     * @return the pipelineId value.
     */
    public Integer pipelineId() {
        return this.pipelineId;
    }

    /**
     * Set the pipelineId property: Reference of the pipeline with which this pipeline instance is related.
     *
     * @param pipelineId the pipelineId value to set.
     * @return the PipelineReferenceBuild object itself.
     */
    public PipelineReferenceBuild withPipelineId(Integer pipelineId) {
        this.pipelineId = pipelineId;
        return this;
    }

    /**
     * Get the stageReference property: Reference of the stage.
     *
     * @return the stageReference value.
     */
    public StageReference stageReference() {
        return this.stageReference;
    }

    /**
     * Set the stageReference property: Reference of the stage.
     *
     * @param stageReference the stageReference value to set.
     * @return the PipelineReferenceBuild object itself.
     */
    public PipelineReferenceBuild withStageReference(StageReference stageReference) {
        this.stageReference = stageReference;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (jobReference() != null) {
            jobReference().validate();
        }
        if (phaseReference() != null) {
            phaseReference().validate();
        }
        if (stageReference() != null) {
            stageReference().validate();
        }
    }
}
