package com.github.brdr3.ceptoaddress.business.service;

import com.github.brdr3.ceptoaddress.core.service.BusinessService;
import com.github.brdr3.ceptoaddress.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {
    @Override
    public void process(final Customer customer) {
        log.info("Processando Customer = {}", customer);
    }
}
