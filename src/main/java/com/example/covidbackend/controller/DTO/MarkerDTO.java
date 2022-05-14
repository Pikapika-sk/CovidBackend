package com.example.covidbackend.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkerDTO {
    private String address;
    private String lng;
    private String lat;
    private String phoneNumber;
}
