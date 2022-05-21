package com.example.covidbackend.entity;

import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplyadminapply {
    private String id;
    private String address;
    private String categoryname;
    private Double quantity;
    private Integer weight;
    private Boolean outState;
    private String note;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private Double needQuantity;


}
