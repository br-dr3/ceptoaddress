package com.github.brdr3.ceptoaddress.gateway.controller;

import com.github.brdr3.ceptoaddress.gateway.dto.CustomerDTO;
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
    public ResponseEntity<CustomerDTO> receiveCep(final CustomerDTO request) {
        log.info("Request recebida = {}", request);
        return ResponseEntity.ok(request);
    }

}
