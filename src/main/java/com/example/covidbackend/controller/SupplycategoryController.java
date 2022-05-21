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

    //物资类型注册
    @PostMapping("/register")
    public boolean register(@RequestBody Supplycategory supplycategory) {
        return supplycategoryService.register(supplycategory);
    }

    //物资批量删除
    @PostMapping("/delBatch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return supplycategoryService.removeBatchByIds(ids);
    }

    //物资
    @GetMapping
    public List<Supplycategory> get() {
        return supplycategoryService.getByAllByTime();  // 根据时间降序返回category列表
    }

    //获取已注册物资类型列表
    @GetMapping("/category")
    public List<String> getcateogry() {      //select中的category数据
        return supplycategoryService.getcategory();
    }

    //获取申请数前10的物资类型名称列表
    @GetMapping("/piechart/name")
    public List<String> getPiechart() {
        return supplycategoryService.getTencateogry();
    }
    //获取申请数量前10的物资类型对应的数量列表
    @GetMapping("/piechart/num")
    public List<Double> getPiechartNum() {
        return supplycategoryService.getTenNum();
    }

}
