package com.londonappbrewery.bitcointicker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "percent",
    "price"
})
public class Changes {

    @JsonProperty("percent")
    private Percent percent;
    @JsonProperty("price")
    private Price price;

    @JsonProperty("percent")
    public Percent getPercent() {
        return percent;
    }

    @JsonProperty("percent")
    public void setPercent(Percent percent) {
        this.percent = percent;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

}
