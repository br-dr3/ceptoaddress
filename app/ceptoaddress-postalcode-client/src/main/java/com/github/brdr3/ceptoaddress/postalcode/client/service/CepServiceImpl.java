package com.github.brdr3.ceptoaddress.postalcode.client.service;

import com.github.brdr3.ceptoaddress.core.service.CepService;
import com.github.brdr3.ceptoaddress.domain.Address;
import com.github.brdr3.ceptoaddress.domain.CepCall;
import com.github.brdr3.ceptoaddress.postalcode.client.config.ClientProperties;
import com.github.brdr3.ceptoaddress.postalcode.client.dto.AddressDTO;
import com.github.brdr3.ceptoaddress.postalcode.client.mapper.AddressDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import static java.lang.String.format;

@Service
public class CepServiceImpl implements CepService {

    private final RestTemplate restTemplate;
    private final ClientProperties.ClientProperty clientProperty;

    private final static String POSTALCODE_VARIABLE = "postalCode";
    private final static String ENDPOINT = "/api/cep/v2/{" + POSTALCODE_VARIABLE + "}";

    public CepServiceImpl(final RestTemplate restTemplate, final ClientProperties clientProperties) {
        this.restTemplate = restTemplate;
        this.clientProperty = clientProperties.getCep();
    }

    @Override
    public CepCall getAddress(final Address address) {
        String url = clientProperty.getUrl() + ENDPOINT;

        LocalDateTime before = LocalDateTime.now();
        ResponseEntity<AddressDTO> response = restTemplate.getForEntity(url, AddressDTO.class,
                Map.of(POSTALCODE_VARIABLE, address.getPostalCode()));
        long duration = Duration.between(before, LocalDateTime.now()).toMillis();

        return AddressDTOMapper.INSTANCE.toCepCall(response.getBody(), url, response.getStatusCode().toString(),
                BigInteger.valueOf(duration));
    }
}
