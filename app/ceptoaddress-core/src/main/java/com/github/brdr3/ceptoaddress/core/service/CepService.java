package com.github.brdr3.ceptoaddress.core.service;

import com.github.brdr3.ceptoaddress.domain.Address;
import com.github.brdr3.ceptoaddress.domain.CepCall;

public interface CepService {
    CepCall getAddress(Address address);
}
