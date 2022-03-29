package com.example.covidbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplyapproval {
    private String id;
    private String categoryname;
    private Double quantity;
    private String reason;
    private Integer weight;
    private Integer state;
    private String phoneNumber;
}
