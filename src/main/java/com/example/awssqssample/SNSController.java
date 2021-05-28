package com.example.awssqssample;

import com.example.awssqssample.event.MessageEvent;
import com.example.awssqssample.event.producer.MessageEventProducer;
import com.example.awssqssample.sns.SnsNotificationSender;
import com.example.awssqssample.worker.event.SnsNotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sns")
public class SNSController {

    private final SnsNotificationSender snsNotificationSender;

    @Autowired
    public SNSController(final SnsNotificationSender snsNotificationSender) {
        this.snsNotificationSender = snsNotificationSender;
    }

    @GetMapping("")
    public String getHelloWorld() {
        return "Hello world SNS!";
    }


    @PostMapping("/publish-message")
    public void sendMessage(
            @RequestBody final SnsNotificationMessage messageEvent
    ) {
        this.snsNotificationSender.send(messageEvent);
    }
}
