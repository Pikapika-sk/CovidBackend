package com.example.covidbackend.controller.DTO;



import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String phoneNumber;
    private String password;
    private String peopleNumber;
    private String address;

}
