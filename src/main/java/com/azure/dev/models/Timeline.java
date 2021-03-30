// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.dev.fluent.models.TimelineInner;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/** An immutable client-side representation of Timeline. */
public interface Timeline {
    /**
     * Gets the changeId property: The change ID.
     *
     * @return the changeId value.
     */
    Integer changeId();

    /**
     * Gets the id property: The ID of the timeline.
     *
     * @return the id value.
     */
    UUID id();

    /**
     * Gets the url property: The REST URL of the timeline.
     *
     * @return the url value.
     */
    String url();

    /**
     * Gets the lastChangedBy property: The process or person that last changed the timeline.
     *
     * @return the lastChangedBy value.
     */
    UUID lastChangedBy();

    /**
     * Gets the lastChangedOn property: The time the timeline was last changed.
     *
     * @return the lastChangedOn value.
     */
    OffsetDateTime lastChangedOn();

    /**
     * Gets the records property: The records property.
     *
     * @return the records value.
     */
    List<TimelineRecord> records();

    /**
     * Gets the inner com.azure.dev.fluent.models.TimelineInner object.
     *
     * @return the inner object.
     */
    TimelineInner innerModel();
}
