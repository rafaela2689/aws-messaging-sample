package com.example.awssqssample.event.producer;

import com.example.awssqssample.event.MessageEvent;
import com.example.awssqssample.worker.sqs.MessageReceivedConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageEventProducer {

    Logger logger = LoggerFactory.getLogger(MessageReceivedConsumer.class);

    private final QueueMessagingTemplate queueMessagingTemplate;

    private final String queueName;

    @Autowired
    public MessageEventProducer(final QueueMessagingTemplate queueMessagingTemplate,
                                @Value("${events.secondQueueJava.queue}") String queueName) {
        this.queueMessagingTemplate = queueMessagingTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(final MessageEvent message) {
        logger.info("[MessageEventProducer] Message has been sent to SQS {} with message {}", queueName, message);
        queueMessagingTemplate.convertAndSend(this.queueName, message);
    }
}
