package com.example.awssqssample.worker.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SnsNotificationMessage {

    @JsonProperty("payload")
    String payload;

}
