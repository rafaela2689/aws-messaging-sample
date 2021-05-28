package com.example.awssqssample.worker.sqs;

import com.example.awssqssample.worker.handler.MessageSNSReceivedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@EnableSqs
public class MessageSNSReceivedConsumer {

    Logger logger = LoggerFactory.getLogger(MessageSNSReceivedConsumer.class);

    private final MessageSNSReceivedHandler handler;

    @Autowired
    public MessageSNSReceivedConsumer(final MessageSNSReceivedHandler messageReceivedHandler) {
        this.handler = messageReceivedHandler;
    }

    @SqsListener("${events.snsTopicSubscribed.queue}")
    public void consumeMessage(final String message) {
        logger.info("[MessageReceivedConsumer] Message received from SQS with message {}", message);
        this.handler.handle(message);
    }
}
