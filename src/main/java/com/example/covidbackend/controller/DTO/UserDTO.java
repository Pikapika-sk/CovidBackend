package com.example.covidbackend.controller.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *
 *  接收前端登录请求的数据
 */
@Data
public class UserDTO {
    private String username;
    private String phoneNumber;
    private String password;
    private String peopleNumber;
    private String address;

}
