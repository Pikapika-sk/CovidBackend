package com.example.covidbackend.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.covidbackend.entity.Supplyinstore;
import com.example.covidbackend.entity.Supplystock;
import com.example.covidbackend.service.SupplystockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class SupplystockController {
    @Autowired
    private SupplystockService supplystockService;

    @GetMapping
    public List<Supplystock> get() {
        List<Supplystock> supplystocks = supplystockService.list();
        return supplystocks;
    }

    @PostMapping("/instore")
    public boolean fromInStore(@RequestBody Supplyinstore supplyinstore) {
        Supplystock supplystock = new Supplystock();
        supplystock.setSupplyname(supplyinstore.getSupplyname());
        supplystock.setCategoryname((supplyinstore.getCategoryname()));
        supplystock.setRemainQuantity(supplyinstore.getQuantity());
        supplystock.setNote((supplyinstore.getNote()));
        Date now = DateUtil.date();
        String date = DateUtil.format(now, "yyyyMMddHHmmss");
        String randomString = RandomUtil.randomNumbers(8);
        String tmp = date + randomString;
        supplystock.setId(tmp);
        return supplystockService.save(supplystock);
    }
}
