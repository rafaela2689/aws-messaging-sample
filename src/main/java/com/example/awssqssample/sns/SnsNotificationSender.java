package com.example.awssqssample.sns;

import com.example.awssqssample.event.MessageEvent;
import com.example.awssqssample.worker.event.SnsNotificationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SnsNotificationSender {

    Logger logger = LoggerFactory.getLogger(SnsNotificationSender.class);

    private final NotificationMessagingTemplate notificationMessagingTemplate;
    private final String topicName;

    @Autowired
    public SnsNotificationSender(final NotificationMessagingTemplate notificationMessagingTemplate,
                                 @Value("${notification.myTopicTest.topic}") String topicName) {
        this.notificationMessagingTemplate = notificationMessagingTemplate;
        this.topicName = topicName;
    }

    public void send(final SnsNotificationMessage message) {
        logger.info("Sending notification message to sns topic");
        this.notificationMessagingTemplate.convertAndSend(this.topicName, message);
    }
}
