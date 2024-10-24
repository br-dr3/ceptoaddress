package com.github.brdr3.ceptoaddress.business.service;

import com.github.brdr3.ceptoaddress.core.service.BusinessService;
import com.github.brdr3.ceptoaddress.core.service.CepService;
import com.github.brdr3.ceptoaddress.core.service.QueueProducer;
import com.github.brdr3.ceptoaddress.domain.Address;
import com.github.brdr3.ceptoaddress.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    private final CepService cepService;
    private final QueueProducer queueProducer;

    @Override
    public void process(final Customer customer) {
        log.info("Processando Customer = {}", customer);

        Address enrichedAddress = cepService.getAddress(customer.getAddress());
        log.info("Endereço enriquecido = {}", enrichedAddress);

        Customer enrichedCustomer = enrich(customer, enrichedAddress);

        queueProducer.produce(enrichedCustomer);
    }

    private static Customer enrich(Customer customer, Address enrichedAddress) {
        Customer enrichedCustomer = new Customer();

        enrichedCustomer.setId(customer.getId());
        enrichedCustomer.setAddress(enrichedAddress);

        return enrichedCustomer;
    }
}
