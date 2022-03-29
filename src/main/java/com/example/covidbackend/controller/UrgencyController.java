package com.example.covidbackend.controller;

import com.example.covidbackend.service.UrgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urgency")
public class UrgencyController {

    @Autowired
    private UrgencyService urgencyService;


}
