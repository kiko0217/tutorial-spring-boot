package com.domain.dto;

import lombok.Data;

@Data
public class TransferData {
    private String norekSource;
    private String norekDestination;
    private double amount;
}
