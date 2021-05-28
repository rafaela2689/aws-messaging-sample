package com.example.awssqssample.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSAsync;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import software.amazon.awssdk.regions.Region;

@Configuration
public class SnsConfiguration {

    @Primary
    @Bean(name = "amazonSnsClient", destroyMethod = "shutdown")
    public AmazonSNSAsync amazonSnsClient() {
        return AmazonSNSAsyncClientBuilder
                .standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(Regions.US_EAST_1)
                .build();
    }

    @Bean
    public NotificationMessagingTemplate notificationMessagingTemplate(final AmazonSNSAsync amazonSns) {
        return new NotificationMessagingTemplate(amazonSns);
    }
}
