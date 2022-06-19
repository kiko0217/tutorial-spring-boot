package com.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressRestClientData {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
}
