package com.github.brdr3.ceptoaddress.messaging.sqs.producer;

import com.github.brdr3.ceptoaddress.core.service.QueueProducer;
import com.github.brdr3.ceptoaddress.domain.Customer;
import com.github.brdr3.ceptoaddress.messaging.sqs.configuration.QueueProperties;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerCepProducerImpl implements QueueProducer {

    private final SqsTemplate sqsTemplate;
    private final QueueProperties properties;

    @Override
    public void produce(Customer customer) {

        MessageHeaders headers = new MessageHeaders(Map.of());
        Message<Customer> message = MessageBuilder.createMessage(customer, headers);

        sqsTemplate.send(properties.getCustomerCep().getQueueName(), message);
        log.info("Message sent = {}", message);
    }
}
