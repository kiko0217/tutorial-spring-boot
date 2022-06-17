package com.domain.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RekeningData {
    
    private Long id;
    @Size(min= 8, max = 255, message = "name between 8-255 characters ")
    private String name;
    @NotEmpty(message = "norek is required")
    private String norek;
    private double saldo;
}
