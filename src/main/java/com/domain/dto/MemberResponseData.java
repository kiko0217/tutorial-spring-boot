package com.domain.dto;

import lombok.Data;

@Data
public class MemberResponseData {
    private Long id;
    private String memberNumber;
    private String memberName;
    private String memberEmail;
}
