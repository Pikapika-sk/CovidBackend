package com.example.covidbackend.controller;


import com.example.covidbackend.entity.Supplycategory;
import com.example.covidbackend.service.SupplycategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplyCategory")
public class SupplycategoryController {
    @Autowired
    private SupplycategoryService supplycategoryService;

    @PostMapping("/register")
    public boolean register(@RequestBody Supplycategory supplycategory){
        return supplycategoryService.register(supplycategory);
    }

}
