package com.example.covidbackend;

import com.example.covidbackend.entity.User;
import com.example.covidbackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@SpringBootApplication
public class CovidBackendApplication {


    public static void main(String[] args) {
        SpringApplication.run(CovidBackendApplication.class, args);
    }



}
