package com.github.brdr3.ceptoaddress.business.service;

import com.github.brdr3.ceptoaddress.core.service.BusinessService;
import com.github.brdr3.ceptoaddress.core.service.CepService;
import com.github.brdr3.ceptoaddress.core.service.QueueProducer;
import com.github.brdr3.ceptoaddress.core.service.Repo;
import com.github.brdr3.ceptoaddress.domain.Address;
import com.github.brdr3.ceptoaddress.domain.CepCall;
import com.github.brdr3.ceptoaddress.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {

    private final CepService cepService;
    private final QueueProducer queueProducer;
    private final Repo<CepCall> cepCallRepository;

    @Override
    public void process(final Customer customer) {
        log.info("Processando Customer = {}", customer);

        CepCall cepCall = cepService.getAddress(customer.getAddress());
        log.info("Chamada ao servico de cep = {}", cepCall);

        cepCallRepository.persist(cepCall);
        log.info("Chamada ao serviço persistida");

        Customer enrichedCustomer = enrich(customer, cepCall);

        queueProducer.produce(enrichedCustomer);
    }

    private static Customer enrich(Customer customer, CepCall enrichedAddress) {
        Customer enrichedCustomer = new Customer();

        enrichedCustomer.setId(customer.getId());
        enrichedCustomer.setAddress(enrichedAddress.getResponse());

        return enrichedCustomer;
    }
}
