package com.londonappbrewery.bitcointicker.model;

import android.util.Log;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.londonappbrewery.bitcointicker.R;

import org.json.JSONObject;

import java.io.IOException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ask",
    "bid",
    "last",
    "high",
    "low",
    "open",
    "averages",
    "volume",
    "changes",
    "volume_percent",
    "timestamp",
    "display_timestamp"
})
public class Ticker {

    @JsonProperty("ask")
    private Double ask;
    @JsonProperty("bid")
    private Double bid;
    @JsonProperty("last")
    private Double last;
    @JsonProperty("high")
    private Double high;
    @JsonProperty("low")
    private Double low;
    @JsonProperty("open")
    private Open open;
    @JsonProperty("averages")
    private Averages averages;
    @JsonProperty("volume")
    private Double volume;
    @JsonProperty("changes")
    private Changes changes;
    @JsonProperty("volume_percent")
    private Double volumePercent;
    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonProperty("display_timestamp")
    private String displayTimestamp;

    @JsonProperty("ask")
    public Double getAsk() {
        return ask;
    }

    @JsonProperty("ask")
    public void setAsk(Double ask) {
        this.ask = ask;
    }

    @JsonProperty("bid")
    public Double getBid() {
        return bid;
    }

    @JsonProperty("bid")
    public void setBid(Double bid) {
        this.bid = bid;
    }

    @JsonProperty("last")
    public Double getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(Double last) {
        this.last = last;
    }

    @JsonProperty("high")
    public Double getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(Double high) {
        this.high = high;
    }

    @JsonProperty("low")
    public Double getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(Double low) {
        this.low = low;
    }

    @JsonProperty("open")
    public Open getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(Open open) {
        this.open = open;
    }

    @JsonProperty("averages")
    public Averages getAverages() {
        return averages;
    }

    @JsonProperty("averages")
    public void setAverages(Averages averages) {
        this.averages = averages;
    }

    @JsonProperty("volume")
    public Double getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @JsonProperty("changes")
    public Changes getChanges() {
        return changes;
    }

    @JsonProperty("changes")
    public void setChanges(Changes changes) {
        this.changes = changes;
    }

    @JsonProperty("volume_percent")
    public Double getVolumePercent() {
        return volumePercent;
    }

    @JsonProperty("volume_percent")
    public void setVolumePercent(Double volumePercent) {
        this.volumePercent = volumePercent;
    }

    @JsonProperty("timestamp")
    public Integer getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("display_timestamp")
    public String getDisplayTimestamp() {
        return displayTimestamp;
    }

    @JsonProperty("display_timestamp")
    public void setDisplayTimestamp(String displayTimestamp) {
        this.displayTimestamp = displayTimestamp;
    }

    public static Ticker fromJson(JSONObject response) {
        Ticker ticker = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ticker = objectMapper.readValue(response.toString(), Ticker.class);
        } catch (IOException e) {
            Log.d("JSON", "Parsing error: " + e.getMessage());
            e.printStackTrace();
        }
        return ticker;
    }

}
