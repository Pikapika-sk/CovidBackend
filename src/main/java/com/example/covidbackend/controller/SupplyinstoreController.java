package com.example.covidbackend.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.covidbackend.entity.Supplyinstore;
import com.example.covidbackend.service.SupplyinstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/supplyInStore")
public class SupplyinstoreController {

    @Autowired
    private SupplyinstoreService supplyService;

    @PostMapping("/register")
    public boolean register(@RequestBody Supplyinstore supplyInStore) {
        Date now = DateUtil.date();
        String date = DateUtil.format(now, "yyyyMMddHHmmss");
        String randomString = RandomUtil.randomNumbers(8);
        String tmp = date + randomString;
        supplyInStore.setId(tmp);
        return supplyService.save(supplyInStore);
    }

    @GetMapping
    public List<Supplyinstore> getAll() {
        List<Supplyinstore> supplyinstores = supplyService.list();
        return supplyinstores;
    }

    @DeleteMapping("{id}")
    public boolean remove(@PathVariable String id) {
        return supplyService.removeById(id);
    }

}
