package com.github.brdr3.ceptoaddress.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {
    private String postalCode;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
}
