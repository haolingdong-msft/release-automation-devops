// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.fluent.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * Represents metadata about builds in the system.
 */
@Fluent
public final class BuildMetricInner {
    /*
     * The date for the scope.
     */
    @JsonProperty(value = "date")
    private OffsetDateTime date;

    /*
     * The value.
     */
    @JsonProperty(value = "intValue")
    private Integer intValue;

    /*
     * The name of the metric.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * The scope.
     */
    @JsonProperty(value = "scope")
    private String scope;

    /**
     * Creates an instance of BuildMetricInner class.
     */
    public BuildMetricInner() {
    }

    /**
     * Get the date property: The date for the scope.
     * 
     * @return the date value.
     */
    public OffsetDateTime date() {
        return this.date;
    }

    /**
     * Set the date property: The date for the scope.
     * 
     * @param date the date value to set.
     * @return the BuildMetricInner object itself.
     */
    public BuildMetricInner withDate(OffsetDateTime date) {
        this.date = date;
        return this;
    }

    /**
     * Get the intValue property: The value.
     * 
     * @return the intValue value.
     */
    public Integer intValue() {
        return this.intValue;
    }

    /**
     * Set the intValue property: The value.
     * 
     * @param intValue the intValue value to set.
     * @return the BuildMetricInner object itself.
     */
    public BuildMetricInner withIntValue(Integer intValue) {
        this.intValue = intValue;
        return this;
    }

    /**
     * Get the name property: The name of the metric.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the metric.
     * 
     * @param name the name value to set.
     * @return the BuildMetricInner object itself.
     */
    public BuildMetricInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the scope property: The scope.
     * 
     * @return the scope value.
     */
    public String scope() {
        return this.scope;
    }

    /**
     * Set the scope property: The scope.
     * 
     * @param scope the scope value to set.
     * @return the BuildMetricInner object itself.
     */
    public BuildMetricInner withScope(String scope) {
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
