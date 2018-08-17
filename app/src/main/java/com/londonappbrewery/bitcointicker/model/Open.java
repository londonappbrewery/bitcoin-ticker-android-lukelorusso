package com.londonappbrewery.bitcointicker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hour",
    "day",
    "week",
    "month",
    "month_3",
    "month_6",
    "year"
})
public class Open {

    @JsonProperty("hour")
    private Double hour;
    @JsonProperty("day")
    private Double day;
    @JsonProperty("week")
    private Double week;
    @JsonProperty("month")
    private Double month;
    @JsonProperty("month_3")
    private Double month3;
    @JsonProperty("month_6")
    private Double month6;
    @JsonProperty("year")
    private Double year;

    @JsonProperty("hour")
    public Double getHour() {
        return hour;
    }

    @JsonProperty("hour")
    public void setHour(Double hour) {
        this.hour = hour;
    }

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

    @JsonProperty("month_3")
    public Double getMonth3() {
        return month3;
    }

    @JsonProperty("month_3")
    public void setMonth3(Double month3) {
        this.month3 = month3;
    }

    @JsonProperty("month_6")
    public Double getMonth6() {
        return month6;
    }

    @JsonProperty("month_6")
    public void setMonth6(Double month6) {
        this.month6 = month6;
    }

    @JsonProperty("year")
    public Double getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Double year) {
        this.year = year;
    }

}
