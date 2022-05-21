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

    //出库信息存储
    @PostMapping("/save")
    public boolean saveOfOutStore(@RequestBody Supplyoutstore supplyoutstore) {
        if (supplyoutstore.getOutQuantity() == 0) return false;
        supplyoutstore.setOutTime(new Date());
        supplyoutstore.setId(new UniqueID().getTheUniqueId());
        return supplyoutstoreService.save(supplyoutstore);
    }

    //获取所有出库列表
    @GetMapping("/getall")
    public List<Supplyoutstore> getall() {
        return supplyoutstoreService.getlistByOrder();
    }

    //出库总数-（未使用）
    @GetMapping("/outsum")
    public Integer getOutSum() {
        return supplyoutstoreService.getOutSum();
    }

    //近7天每一天的出库数量
    @GetMapping("/getPurpledata")
    public List<Long> getPurpleData() {
        return supplyoutstoreService.getPurpledata();
    }

    //近7天出库总数
    @GetMapping("/getSevenDaySum")
    public String getSevenDaySum() {
        return supplyoutstoreService.getSevenDaySum();
    }
}
