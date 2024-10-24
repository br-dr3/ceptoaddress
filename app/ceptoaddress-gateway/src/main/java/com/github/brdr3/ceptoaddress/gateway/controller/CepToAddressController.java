package com.github.brdr3.ceptoaddress.gateway.controller;

import com.github.brdr3.ceptoaddress.domain.Customer;
import com.github.brdr3.ceptoaddress.gateway.dto.CustomerDTO;
import com.github.brdr3.ceptoaddress.gateway.mapper.CustomerDTOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ceptoaddress")
public class CepToAddressController {

    @PostMapping("/")
    public ResponseEntity<Customer> receiveCep(final CustomerDTO request) {
        log.info("Request recebida = {}", request);

        Customer customer = CustomerDTOMapper.INSTANCE.toCustomer(request);

        log.info("Domain = {}", customer);

        return ResponseEntity.ok(customer);
    }

}
