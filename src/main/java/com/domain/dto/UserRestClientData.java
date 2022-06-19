package com.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRestClientData {
    private Long id;
    private String name;
    private String username;
    private String email;
    private AddressRestClientData address;
    private String phone;
    private String website;
    private CompanyRestClientData company;

}
