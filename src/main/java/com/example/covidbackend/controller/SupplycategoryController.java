package com.example.covidbackend.controller;


import com.example.covidbackend.entity.Supplycategory;
import com.example.covidbackend.service.SupplycategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplyCategory")
public class SupplycategoryController {
    @Autowired
    private SupplycategoryService supplycategoryService;

    @PostMapping("/register")
    public boolean register(@RequestBody Supplycategory supplycategory) {
        return supplycategoryService.register(supplycategory);
    }

    @PostMapping("/delBatch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return supplycategoryService.removeBatchByIds(ids);
    }

    @GetMapping
    public List<Supplycategory> get() {
        return supplycategoryService.getByAllByTime();//        根据时间降序返回category列表
    }
    @GetMapping("/category")
    public List<String> getcateogry() {      //select中的category数据
        List<String> supplycategories = supplycategoryService.getcategory();
        return supplycategories;
    }

}
