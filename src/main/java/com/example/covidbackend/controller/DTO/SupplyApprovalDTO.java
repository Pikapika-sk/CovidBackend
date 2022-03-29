package com.example.covidbackend.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyApprovalDTO {
    private String categoryname;
    private Double quantity;
    private String reason;
    private String phoneNumber;
}
