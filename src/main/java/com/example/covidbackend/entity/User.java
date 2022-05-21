package com.example.covidbackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId
    private String phoneNumber;
    private String username;
    private String address;
    private String password;
    private Integer peopleNumber;
    private Boolean isadmin;
}
