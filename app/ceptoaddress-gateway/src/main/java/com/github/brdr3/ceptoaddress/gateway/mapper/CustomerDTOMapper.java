package com.github.brdr3.ceptoaddress.gateway.mapper;

import com.github.brdr3.ceptoaddress.domain.Address;
import com.github.brdr3.ceptoaddress.domain.Customer;
import com.github.brdr3.ceptoaddress.gateway.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerDTOMapper {

    CustomerDTOMapper INSTANCE = Mappers.getMapper(CustomerDTOMapper.class);

    @Mapping(target = "id", source = "customerId")
    @Mapping(target = "address", source = "customerDTO")
    Customer toCustomer(CustomerDTO customerDTO);

    @Mapping(target = "postalCode", source = "postalCode")
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "neighborhood", ignore = true)
    @Mapping(target = "street", ignore = true)
    Address toAddress(CustomerDTO customerDTO);

}
