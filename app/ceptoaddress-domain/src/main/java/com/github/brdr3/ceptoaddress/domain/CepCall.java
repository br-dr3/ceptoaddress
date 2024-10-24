package com.github.brdr3.ceptoaddress.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class CepCall {
    private String url;
    private Address response;
    private String responseStatus;
    private BigInteger responseTime;
}
