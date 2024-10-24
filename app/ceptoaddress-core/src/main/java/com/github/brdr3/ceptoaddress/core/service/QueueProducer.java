package com.github.brdr3.ceptoaddress.core.service;

import com.github.brdr3.ceptoaddress.domain.Customer;

public interface QueueProducer {

    void produce(final Customer customer);

}
