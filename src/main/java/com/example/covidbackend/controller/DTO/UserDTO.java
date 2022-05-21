package com.example.covidbackend.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String phoneNumber;
    private String password;
    private String peopleNumber;
    private String address;

}
