package com.example.awssqssample.worker.handler;

import com.example.awssqssample.worker.event.SnsNotification;
import com.example.awssqssample.worker.event.SnsNotificationMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageSNSReceivedHandler {

    public void handle(final String message) {
        System.out.println("My message from SNS topic type:" + message);
    }
}
