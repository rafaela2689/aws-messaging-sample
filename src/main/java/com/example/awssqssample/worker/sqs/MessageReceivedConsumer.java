package com.example.awssqssample.worker.sqs;

import com.example.awssqssample.event.MessageEvent;
import com.example.awssqssample.worker.handler.MessageReceivedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@EnableSqs
public class MessageReceivedConsumer {

    Logger logger = LoggerFactory.getLogger(MessageReceivedConsumer.class);

    private final MessageReceivedHandler handler;

    @Autowired
    public MessageReceivedConsumer(final MessageReceivedHandler messageReceivedHandler) {
        this.handler = messageReceivedHandler;
    }

    @SqsListener("${events.secondQueueJava.queue}")
    public void consumeMessage(final MessageEvent message) {
        logger.info("[MessageReceivedConsumer] Message received from SQS with message {}", message);
        this.handler.handle(message);
    }
}
