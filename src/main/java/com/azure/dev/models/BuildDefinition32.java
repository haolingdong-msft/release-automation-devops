// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.dev.fluent.models.BuildDefinition32Inner;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/** An immutable client-side representation of BuildDefinition32. */
public interface BuildDefinition32 {
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
     * Gets the badgeEnabled property: Indicates whether badges are enabled for this definition.
     *
     * @return the badgeEnabled value.
     */
    Boolean badgeEnabled();

    /**
     * Gets the build property: The build property.
     *
     * @return the build value.
     */
    List<BuildDefinitionStep> build();

    /**
     * Gets the buildNumberFormat property: The build number format.
     *
     * @return the buildNumberFormat value.
     */
    String buildNumberFormat();

    /**
     * Gets the comment property: The comment entered when saving the definition.
     *
     * @return the comment value.
     */
    String comment();

    /**
     * Gets the demands property: The demands property.
     *
     * @return the demands value.
     */
    List<Demand> demands();

    /**
     * Gets the description property: The description.
     *
     * @return the description value.
     */
    String description();

    /**
     * Gets the dropLocation property: The drop location for the definition.
     *
     * @return the dropLocation value.
     */
    String dropLocation();

    /**
     * Gets the jobAuthorizationScope property: The job authorization scope for builds which are queued against this
     * definition.
     *
     * @return the jobAuthorizationScope value.
     */
    BuildAuthorizationScope jobAuthorizationScope();

    /**
     * Gets the jobCancelTimeoutInMinutes property: The job cancel timeout in minutes for builds which are cancelled by
     * user for this definition.
     *
     * @return the jobCancelTimeoutInMinutes value.
     */
    Integer jobCancelTimeoutInMinutes();

    /**
     * Gets the jobTimeoutInMinutes property: The job execution timeout in minutes for builds which are queued against
     * this definition.
     *
     * @return the jobTimeoutInMinutes value.
     */
    Integer jobTimeoutInMinutes();

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
     * Gets the options property: The options property.
     *
     * @return the options value.
     */
    List<BuildOption> options();

    /**
     * Gets the processParameters property: Process Parameters.
     *
     * @return the processParameters value.
     */
    ProcessParameters processParameters();

    /**
     * Gets the properties property: The class represents a property bag as a collection of key-value pairs. Values of
     * all primitive types (any type with a `TypeCode != TypeCode.Object`) except for `DBNull` are accepted. Values of
     * type Byte[], Int32, Double, DateType and String preserve their type, other primitives are retuned as a String.
     * Byte[] expected as base64 encoded string.
     *
     * @return the properties value.
     */
    PropertiesCollection properties();

    /**
     * Gets the repository property: The repository.
     *
     * @return the repository value.
     */
    BuildRepository repository();

    /**
     * Gets the retentionRules property: The retentionRules property.
     *
     * @return the retentionRules value.
     */
    List<RetentionPolicy> retentionRules();

    /**
     * Gets the tags property: The tags property.
     *
     * @return the tags value.
     */
    List<String> tags();

    /**
     * Gets the triggers property: The triggers property.
     *
     * @return the triggers value.
     */
    List<BuildTrigger> triggers();

    /**
     * Gets the variables property: Dictionary of &lt;BuildDefinitionVariable&gt;.
     *
     * @return the variables value.
     */
    Map<String, BuildDefinitionVariable> variables();

    /**
     * Gets the inner com.azure.dev.fluent.models.BuildDefinition32Inner object.
     *
     * @return the inner object.
     */
    BuildDefinition32Inner innerModel();
}
