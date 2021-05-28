package com.example.awssqssample.worker.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SnsNotification {

    @JsonProperty("Type")
    String type;

    @JsonProperty("MessageId")
    String messageId;

    @JsonProperty("TopicArn")
    String topicArn;

    @JsonProperty("Message")
    String message;

    @JsonProperty("Timestamp")
    String timestamp;
}
