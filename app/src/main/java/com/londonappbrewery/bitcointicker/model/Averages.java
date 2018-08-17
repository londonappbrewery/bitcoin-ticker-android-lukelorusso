package com.londonappbrewery.bitcointicker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "day",
    "week",
    "month"
})
public class Averages {

    @JsonProperty("day")
    private Double day;
    @JsonProperty("week")
    private Double week;
    @JsonProperty("month")
    private Double month;

    @JsonProperty("day")
    public Double getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Double day) {
        this.day = day;
    }

    @JsonProperty("week")
    public Double getWeek() {
        return week;
    }

    @JsonProperty("week")
    public void setWeek(Double week) {
        this.week = week;
    }

    @JsonProperty("month")
    public Double getMonth() {
        return month;
    }

    @JsonProperty("month")
    public void setMonth(Double month) {
        this.month = month;
    }

}
