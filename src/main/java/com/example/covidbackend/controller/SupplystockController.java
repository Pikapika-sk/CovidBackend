package com.example.covidbackend.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.covidbackend.entity.Supplyinstore;
import com.example.covidbackend.entity.Supplystock;
import com.example.covidbackend.service.SupplystockService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class SupplystockController {
    @Autowired
    private SupplystockService supplystockService;

    @GetMapping
    public List<Supplystock> get() {
        return supplystockService.getListByOrder();
    }

    //新增库存信息
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
        if (supplystock.getNote() == null || supplystock.getNote() == "") supplystock.setNote("无");
        return supplystockService.save(supplystock);
    }

    //获取特定类型物资库存情况
    @GetMapping("/{categoryname}")
    public List<Supplystock> getSupply(@PathVariable String categoryname) {
        return supplystockService.getofCategory(categoryname);
    }

    //更新库存情况
    @PostMapping("/outStore")
    public boolean outFromStroe(@RequestBody Supplystock supplystock) {
        return supplystockService.updateById(supplystock);
    }

    //删除库存信息
    @DeleteMapping("/del/{id}")
    public boolean delStock(@PathVariable String id) {
        return supplystockService.removeById(id);
    }

    //获取所有库存总数（未使用）
    @GetMapping("/getsum")
    public Integer getSum() {
        return supplystockService.getsum();
    }

}
