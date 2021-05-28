package com.example.awssqssample;

import com.example.awssqssample.event.MessageEvent;
import com.example.awssqssample.event.producer.MessageEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sqs")
public class SQSController {

    private final MessageEventProducer eventProducer;

    @Autowired
    public SQSController(final MessageEventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @GetMapping("")
    public String getHelloWorld() {
        return "Hello world SQS!";
    }


    @PostMapping("/send-message")
    public void sendMessage(
            @RequestBody final MessageEvent message
    ) {
        this.eventProducer.sendMessage(message);
    }
}
