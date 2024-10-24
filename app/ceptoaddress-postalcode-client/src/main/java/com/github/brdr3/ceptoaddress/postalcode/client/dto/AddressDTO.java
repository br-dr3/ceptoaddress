package com.github.brdr3.ceptoaddress.postalcode.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;
    private LocationDTO location;
}