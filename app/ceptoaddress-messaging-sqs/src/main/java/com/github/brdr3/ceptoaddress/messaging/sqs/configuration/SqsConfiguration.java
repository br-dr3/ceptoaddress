package com.github.brdr3.ceptoaddress.messaging.sqs.configuration;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
@EnableConfigurationProperties(QueueProperties.class)
public class SqsConfiguration {

    @Bean
    public AwsCredentials awsCredentials(final QueueProperties properties) {
        return AwsBasicCredentials.create(properties.getAccessKeyId(), properties.getSecretAccessKey());
    }

    @Bean
    @Primary
    @Profile("local")
    public SqsAsyncClient sqsAsyncClient(final AwsCredentialsProvider awsCredentialsProvider) {
        return SqsAsyncClient.builder()
                .credentialsProvider(awsCredentialsProvider)
                .endpointOverride(URI.create("http://localhost:4566"))
                .build();
    }

    @Bean
    @Profile("local")
    public SqsTemplate sqsTemplate(final SqsAsyncClient sqsAsyncClient) {
        return SqsTemplate.builder()
                .sqsAsyncClient(sqsAsyncClient)
                .build();
    }
}
