package com.github.brdr3.ceptoaddress.gateway.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class CustomerDTO {
    private UUID customerId;
    private String postalCode;
}
