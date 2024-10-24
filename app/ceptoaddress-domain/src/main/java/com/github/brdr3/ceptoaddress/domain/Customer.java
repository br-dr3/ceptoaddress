package com.github.brdr3.ceptoaddress.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Customer {
    private UUID id;
    private Address address;
}
