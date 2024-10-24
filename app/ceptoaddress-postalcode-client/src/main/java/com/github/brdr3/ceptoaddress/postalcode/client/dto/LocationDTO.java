package com.github.brdr3.ceptoaddress.postalcode.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
    private String type;
    private CoordinatesDTO coordinates;
}
