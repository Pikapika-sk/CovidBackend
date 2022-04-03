package com.example.covidbackend.controller.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrgencyDTO {
    private String phoneNumber ;
    private String content;

}
