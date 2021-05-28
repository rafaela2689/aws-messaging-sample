package com.example.awssqssample.worker.handler;

import com.example.awssqssample.event.MessageEvent;
import org.springframework.stereotype.Service;

@Service
public class MessageReceivedHandler {

    public void handle(final MessageEvent message) {
        System.out.println("My message type:" + message.getEventType());
    }
}
