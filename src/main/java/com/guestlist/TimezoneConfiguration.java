package com.guestlist;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class TimezoneConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String defaultTimezone;

    public String getDefaultTimezone() { return defaultTimezone; }
}