package com.github.brdr3.ceptoaddress.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Customer {
    private UUID id;
    private Address address;
}
