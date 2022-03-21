package com.example.covidbackend.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)

    private Integer id;
    private String username;
    private String address;
    private String password;
    private String phoneNumber;
    private Integer peopleNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastReceiveTime; //时间

}
