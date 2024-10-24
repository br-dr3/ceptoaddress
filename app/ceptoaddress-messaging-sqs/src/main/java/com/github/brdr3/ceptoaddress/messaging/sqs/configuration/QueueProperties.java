package com.github.brdr3.ceptoaddress.messaging.sqs.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("sqs")
public class QueueProperties {

    private String accessKeyId;
    private String secretAccessKey;

    private QueueProperty customerCep = new QueueProperty();

    @Getter
    @Setter
    public static class QueueProperty {
        String queueName;
    }

}
