// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.dev.models.TimelineRecord;
import com.azure.dev.models.TimelineReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/** Represents the timeline of a build. */
@Fluent
public final class TimelineInner extends TimelineReference {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(TimelineInner.class);

    /*
     * The process or person that last changed the timeline.
     */
    @JsonProperty(value = "lastChangedBy")
    private UUID lastChangedBy;

    /*
     * The time the timeline was last changed.
     */
    @JsonProperty(value = "lastChangedOn")
    private OffsetDateTime lastChangedOn;

    /*
     * The records property.
     */
    @JsonProperty(value = "records")
    private List<TimelineRecord> records;

    /**
     * Get the lastChangedBy property: The process or person that last changed the timeline.
     *
     * @return the lastChangedBy value.
     */
    public UUID lastChangedBy() {
        return this.lastChangedBy;
    }

    /**
     * Set the lastChangedBy property: The process or person that last changed the timeline.
     *
     * @param lastChangedBy the lastChangedBy value to set.
     * @return the TimelineInner object itself.
     */
    public TimelineInner withLastChangedBy(UUID lastChangedBy) {
        this.lastChangedBy = lastChangedBy;
        return this;
    }

    /**
     * Get the lastChangedOn property: The time the timeline was last changed.
     *
     * @return the lastChangedOn value.
     */
    public OffsetDateTime lastChangedOn() {
        return this.lastChangedOn;
    }

    /**
     * Set the lastChangedOn property: The time the timeline was last changed.
     *
     * @param lastChangedOn the lastChangedOn value to set.
     * @return the TimelineInner object itself.
     */
    public TimelineInner withLastChangedOn(OffsetDateTime lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
        return this;
    }

    /**
     * Get the records property: The records property.
     *
     * @return the records value.
     */
    public List<TimelineRecord> records() {
        return this.records;
    }

    /**
     * Set the records property: The records property.
     *
     * @param records the records value to set.
     * @return the TimelineInner object itself.
     */
    public TimelineInner withRecords(List<TimelineRecord> records) {
        this.records = records;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TimelineInner withChangeId(Integer changeId) {
        super.withChangeId(changeId);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TimelineInner withId(UUID id) {
        super.withId(id);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TimelineInner withUrl(String url) {
        super.withUrl(url);
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
        if (records() != null) {
            records().forEach(e -> e.validate());
        }
    }
}
