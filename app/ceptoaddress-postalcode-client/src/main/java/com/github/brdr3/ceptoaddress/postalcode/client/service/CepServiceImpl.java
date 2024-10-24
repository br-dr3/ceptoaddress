package com.github.brdr3.ceptoaddress.postalcode.client.service;

import com.github.brdr3.ceptoaddress.core.service.CepService;
import com.github.brdr3.ceptoaddress.domain.Address;
import com.github.brdr3.ceptoaddress.postalcode.client.config.ClientProperties;
import com.github.brdr3.ceptoaddress.postalcode.client.dto.AddressDTO;
import com.github.brdr3.ceptoaddress.postalcode.client.mapper.AddressDTOMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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
    public Address getAddress(final Address address) {
        final AddressDTO addressDTO = restTemplate.getForObject(clientProperty.getUrl() + ENDPOINT, AddressDTO.class,
                Map.of(POSTALCODE_VARIABLE, address.getPostalCode()));

        return AddressDTOMapper.INSTANCE.toDomain(addressDTO);
    }
}
