// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents a dependency. */
@Fluent
public final class Dependency {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(Dependency.class);

    /*
     * The event. The dependency is satisfied when the referenced object emits
     * this event.
     */
    @JsonProperty(value = "event")
    private String event;

    /*
     * The scope. This names the object referenced by the dependency.
     */
    @JsonProperty(value = "scope")
    private String scope;

    /**
     * Get the event property: The event. The dependency is satisfied when the referenced object emits this event.
     *
     * @return the event value.
     */
    public String event() {
        return this.event;
    }

    /**
     * Set the event property: The event. The dependency is satisfied when the referenced object emits this event.
     *
     * @param event the event value to set.
     * @return the Dependency object itself.
     */
    public Dependency withEvent(String event) {
        this.event = event;
        return this;
    }

    /**
     * Get the scope property: The scope. This names the object referenced by the dependency.
     *
     * @return the scope value.
     */
    public String scope() {
        return this.scope;
    }

    /**
     * Set the scope property: The scope. This names the object referenced by the dependency.
     *
     * @param scope the scope value to set.
     * @return the Dependency object itself.
     */
    public Dependency withScope(String scope) {
        this.scope = scope;
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
