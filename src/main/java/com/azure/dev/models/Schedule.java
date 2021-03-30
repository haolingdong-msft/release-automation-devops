// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.UUID;

/** The Schedule model. */
@Fluent
public final class Schedule {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(Schedule.class);

    /*
     * The branchFilters property.
     */
    @JsonProperty(value = "branchFilters")
    private List<String> branchFilters;

    /*
     * Days for a build (flags enum for days of the week)
     */
    @JsonProperty(value = "daysToBuild")
    private ScheduleDays daysToBuild;

    /*
     * The Job Id of the Scheduled job that will queue the scheduled build.
     * Since a single trigger can have multiple schedules and we want a single
     * job to process a single schedule (since each schedule has a list of
     * branches to build), the schedule itself needs to define the Job Id. This
     * value will be filled in when a definition is added or updated.  The UI
     * does not provide it or use it.
     */
    @JsonProperty(value = "scheduleJobId")
    private UUID scheduleJobId;

    /*
     * Flag to determine if this schedule should only build if the associated
     * source has been changed.
     */
    @JsonProperty(value = "scheduleOnlyWithChanges")
    private Boolean scheduleOnlyWithChanges;

    /*
     * Local timezone hour to start
     */
    @JsonProperty(value = "startHours")
    private Integer startHours;

    /*
     * Local timezone minute to start
     */
    @JsonProperty(value = "startMinutes")
    private Integer startMinutes;

    /*
     * Time zone of the build schedule (String representation of the time zone
     * ID)
     */
    @JsonProperty(value = "timeZoneId")
    private String timeZoneId;

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
     * @return the Schedule object itself.
     */
    public Schedule withBranchFilters(List<String> branchFilters) {
        this.branchFilters = branchFilters;
        return this;
    }

    /**
     * Get the daysToBuild property: Days for a build (flags enum for days of the week).
     *
     * @return the daysToBuild value.
     */
    public ScheduleDays daysToBuild() {
        return this.daysToBuild;
    }

    /**
     * Set the daysToBuild property: Days for a build (flags enum for days of the week).
     *
     * @param daysToBuild the daysToBuild value to set.
     * @return the Schedule object itself.
     */
    public Schedule withDaysToBuild(ScheduleDays daysToBuild) {
        this.daysToBuild = daysToBuild;
        return this;
    }

    /**
     * Get the scheduleJobId property: The Job Id of the Scheduled job that will queue the scheduled build. Since a
     * single trigger can have multiple schedules and we want a single job to process a single schedule (since each
     * schedule has a list of branches to build), the schedule itself needs to define the Job Id. This value will be
     * filled in when a definition is added or updated. The UI does not provide it or use it.
     *
     * @return the scheduleJobId value.
     */
    public UUID scheduleJobId() {
        return this.scheduleJobId;
    }

    /**
     * Set the scheduleJobId property: The Job Id of the Scheduled job that will queue the scheduled build. Since a
     * single trigger can have multiple schedules and we want a single job to process a single schedule (since each
     * schedule has a list of branches to build), the schedule itself needs to define the Job Id. This value will be
     * filled in when a definition is added or updated. The UI does not provide it or use it.
     *
     * @param scheduleJobId the scheduleJobId value to set.
     * @return the Schedule object itself.
     */
    public Schedule withScheduleJobId(UUID scheduleJobId) {
        this.scheduleJobId = scheduleJobId;
        return this;
    }

    /**
     * Get the scheduleOnlyWithChanges property: Flag to determine if this schedule should only build if the associated
     * source has been changed.
     *
     * @return the scheduleOnlyWithChanges value.
     */
    public Boolean scheduleOnlyWithChanges() {
        return this.scheduleOnlyWithChanges;
    }

    /**
     * Set the scheduleOnlyWithChanges property: Flag to determine if this schedule should only build if the associated
     * source has been changed.
     *
     * @param scheduleOnlyWithChanges the scheduleOnlyWithChanges value to set.
     * @return the Schedule object itself.
     */
    public Schedule withScheduleOnlyWithChanges(Boolean scheduleOnlyWithChanges) {
        this.scheduleOnlyWithChanges = scheduleOnlyWithChanges;
        return this;
    }

    /**
     * Get the startHours property: Local timezone hour to start.
     *
     * @return the startHours value.
     */
    public Integer startHours() {
        return this.startHours;
    }

    /**
     * Set the startHours property: Local timezone hour to start.
     *
     * @param startHours the startHours value to set.
     * @return the Schedule object itself.
     */
    public Schedule withStartHours(Integer startHours) {
        this.startHours = startHours;
        return this;
    }

    /**
     * Get the startMinutes property: Local timezone minute to start.
     *
     * @return the startMinutes value.
     */
    public Integer startMinutes() {
        return this.startMinutes;
    }

    /**
     * Set the startMinutes property: Local timezone minute to start.
     *
     * @param startMinutes the startMinutes value to set.
     * @return the Schedule object itself.
     */
    public Schedule withStartMinutes(Integer startMinutes) {
        this.startMinutes = startMinutes;
        return this;
    }

    /**
     * Get the timeZoneId property: Time zone of the build schedule (String representation of the time zone ID).
     *
     * @return the timeZoneId value.
     */
    public String timeZoneId() {
        return this.timeZoneId;
    }

    /**
     * Set the timeZoneId property: Time zone of the build schedule (String representation of the time zone ID).
     *
     * @param timeZoneId the timeZoneId value to set.
     * @return the Schedule object itself.
     */
    public Schedule withTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
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
