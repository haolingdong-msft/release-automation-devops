// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * The SupportedTrigger model.
 */
@Fluent
public final class SupportedTrigger {
    /*
     * The default interval to wait between polls (only relevant when NotificationType is Polling).
     */
    @JsonProperty(value = "defaultPollingInterval")
    private Integer defaultPollingInterval;

    /*
     * How the trigger is notified of changes.
     */
    @JsonProperty(value = "notificationType")
    private String notificationType;

    /*
     * The capabilities supported by this trigger.
     */
    @JsonProperty(value = "supportedCapabilities")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, SupportLevel> supportedCapabilities;

    /*
     * The type of trigger.
     */
    @JsonProperty(value = "type")
    private DefinitionTriggerType type;

    /**
     * Creates an instance of SupportedTrigger class.
     */
    public SupportedTrigger() {
    }

    /**
     * Get the defaultPollingInterval property: The default interval to wait between polls (only relevant when
     * NotificationType is Polling).
     * 
     * @return the defaultPollingInterval value.
     */
    public Integer defaultPollingInterval() {
        return this.defaultPollingInterval;
    }

    /**
     * Set the defaultPollingInterval property: The default interval to wait between polls (only relevant when
     * NotificationType is Polling).
     * 
     * @param defaultPollingInterval the defaultPollingInterval value to set.
     * @return the SupportedTrigger object itself.
     */
    public SupportedTrigger withDefaultPollingInterval(Integer defaultPollingInterval) {
        this.defaultPollingInterval = defaultPollingInterval;
        return this;
    }

    /**
     * Get the notificationType property: How the trigger is notified of changes.
     * 
     * @return the notificationType value.
     */
    public String notificationType() {
        return this.notificationType;
    }

    /**
     * Set the notificationType property: How the trigger is notified of changes.
     * 
     * @param notificationType the notificationType value to set.
     * @return the SupportedTrigger object itself.
     */
    public SupportedTrigger withNotificationType(String notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    /**
     * Get the supportedCapabilities property: The capabilities supported by this trigger.
     * 
     * @return the supportedCapabilities value.
     */
    public Map<String, SupportLevel> supportedCapabilities() {
        return this.supportedCapabilities;
    }

    /**
     * Set the supportedCapabilities property: The capabilities supported by this trigger.
     * 
     * @param supportedCapabilities the supportedCapabilities value to set.
     * @return the SupportedTrigger object itself.
     */
    public SupportedTrigger withSupportedCapabilities(Map<String, SupportLevel> supportedCapabilities) {
        this.supportedCapabilities = supportedCapabilities;
        return this;
    }

    /**
     * Get the type property: The type of trigger.
     * 
     * @return the type value.
     */
    public DefinitionTriggerType type() {
        return this.type;
    }

    /**
     * Set the type property: The type of trigger.
     * 
     * @param type the type value to set.
     * @return the SupportedTrigger object itself.
     */
    public SupportedTrigger withType(DefinitionTriggerType type) {
        this.type = type;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
