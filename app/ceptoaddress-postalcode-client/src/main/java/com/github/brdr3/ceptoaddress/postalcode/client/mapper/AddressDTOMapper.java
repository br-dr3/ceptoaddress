package com.github.brdr3.ceptoaddress.postalcode.client.mapper;

import com.github.brdr3.ceptoaddress.domain.Address;
import com.github.brdr3.ceptoaddress.domain.CepCall;
import com.github.brdr3.ceptoaddress.postalcode.client.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigInteger;

@Mapper
public interface AddressDTOMapper {

    AddressDTOMapper INSTANCE = Mappers.getMapper(AddressDTOMapper.class);

    @Mapping(target = "postalCode", source = "cep")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "neighborhood", source = "neighborhood")
    @Mapping(target = "street", source = "street")
    Address toDomain(final AddressDTO address);

    @Mapping(target = "url", source = "url")
    @Mapping(target = "response", source = "address")
    @Mapping(target = "responseStatus", source = "responseStatus")
    @Mapping(target = "responseTime", source = "responseTime")
    CepCall toCepCall(final AddressDTO address, final String url, final String responseStatus, final BigInteger responseTime);
}
