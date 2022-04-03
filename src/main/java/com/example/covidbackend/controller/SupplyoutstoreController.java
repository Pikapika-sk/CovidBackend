package com.example.covidbackend.controller;


import com.example.covidbackend.Util.UniqueID;
import com.example.covidbackend.entity.Supplyoutstore;
import com.example.covidbackend.service.SupplyoutstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/outStore")
public class SupplyoutstoreController {

    @Autowired
    private SupplyoutstoreService supplyoutstoreService;

    @PostMapping("/save")
    public boolean saveOfOutStore(@RequestBody Supplyoutstore supplyoutstore) {
        supplyoutstore.setOutTime(new Date());
        supplyoutstore.setId(new UniqueID().getTheUniqueId());

        return supplyoutstoreService.save(supplyoutstore);
    }
    @GetMapping("/getall")
    public List<Supplyoutstore> getall(){
        return supplyoutstoreService.list();
    }
}
