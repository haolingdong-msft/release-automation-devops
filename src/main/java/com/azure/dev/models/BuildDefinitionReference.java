// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.dev.fluent.models.BuildDefinitionReferenceInner;
import java.time.OffsetDateTime;
import java.util.List;

/** An immutable client-side representation of BuildDefinitionReference. */
public interface BuildDefinitionReference {
    /**
     * Gets the createdDate property: The date this version of the definition was created.
     *
     * @return the createdDate value.
     */
    OffsetDateTime createdDate();

    /**
     * Gets the id property: The ID of the referenced definition.
     *
     * @return the id value.
     */
    Integer id();

    /**
     * Gets the name property: The name of the referenced definition.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the path property: The folder path of the definition.
     *
     * @return the path value.
     */
    String path();

    /**
     * Gets the project property: A reference to the project.
     *
     * @return the project value.
     */
    TeamProjectReference project();

    /**
     * Gets the queueStatus property: A value that indicates whether builds can be queued against this definition.
     *
     * @return the queueStatus value.
     */
    DefinitionQueueStatus queueStatus();

    /**
     * Gets the revision property: The definition revision number.
     *
     * @return the revision value.
     */
    Integer revision();

    /**
     * Gets the type property: The type of the definition.
     *
     * @return the type value.
     */
    DefinitionType type();

    /**
     * Gets the uri property: The definition's URI.
     *
     * @return the uri value.
     */
    String uri();

    /**
     * Gets the url property: The REST URL of the definition.
     *
     * @return the url value.
     */
    String url();

    /**
     * Gets the links property: The class to represent a collection of REST reference links.
     *
     * @return the links value.
     */
    ReferenceLinks links();

    /**
     * Gets the authoredBy property: The author of the definition.
     *
     * @return the authoredBy value.
     */
    IdentityRef authoredBy();

    /**
     * Gets the draftOf property: A reference to the definition that this definition is a draft of, if this is a draft
     * definition.
     *
     * @return the draftOf value.
     */
    DefinitionReference draftOf();

    /**
     * Gets the drafts property: The list of drafts associated with this definition, if this is not a draft definition.
     *
     * @return the drafts value.
     */
    List<DefinitionReference> drafts();

    /**
     * Gets the latestBuild property: Data representation of a build.
     *
     * @return the latestBuild value.
     */
    Build latestBuild();

    /**
     * Gets the latestCompletedBuild property: Data representation of a build.
     *
     * @return the latestCompletedBuild value.
     */
    Build latestCompletedBuild();

    /**
     * Gets the metrics property: The metrics property.
     *
     * @return the metrics value.
     */
    List<BuildMetric> metrics();

    /**
     * Gets the quality property: The quality of the definition document (draft, etc.).
     *
     * @return the quality value.
     */
    DefinitionQuality quality();

    /**
     * Gets the queue property: The default queue for builds run against this definition.
     *
     * @return the queue value.
     */
    AgentPoolQueue queue();

    /**
     * Gets the inner com.azure.dev.fluent.models.BuildDefinitionReferenceInner object.
     *
     * @return the inner object.
     */
    BuildDefinitionReferenceInner innerModel();
}
