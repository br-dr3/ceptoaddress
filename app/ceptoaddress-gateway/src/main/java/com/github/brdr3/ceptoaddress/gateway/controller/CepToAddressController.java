package com.github.brdr3.ceptoaddress.gateway.controller;

import com.github.brdr3.ceptoaddress.core.service.BusinessService;
import com.github.brdr3.ceptoaddress.domain.Customer;
import com.github.brdr3.ceptoaddress.gateway.dto.CustomerDTO;
import com.github.brdr3.ceptoaddress.gateway.mapper.CustomerDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ceptoaddress")
public class CepToAddressController {

    private final BusinessService businessService;

    @PostMapping("/")
    public ResponseEntity<Customer> receiveCep(final CustomerDTO request) {
        log.info("Request recebida = {}", request);

        Customer customer = CustomerDTOMapper.INSTANCE.toCustomer(request);
        log.info("Domain = {}", customer);

        businessService.process(customer);

        return ResponseEntity.ok(customer);
    }

}
