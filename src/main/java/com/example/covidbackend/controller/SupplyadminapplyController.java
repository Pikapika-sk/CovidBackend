package com.example.covidbackend.controller;


import com.example.covidbackend.entity.Supplyadminapply;
import com.example.covidbackend.service.SupplyadminapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminApply")
public class SupplyadminapplyController {

    @Autowired
    private SupplyadminapplyService supplyadminapplyService;

    //增加管理员申请
    @PostMapping("/set")
    public boolean adminApplySet(@RequestBody Supplyadminapply supplyadminapply) {
        return supplyadminapplyService.saveTheApply(supplyadminapply);
    }

    //更新管理员申请状态
    @PostMapping("/update")
    public boolean adminApplyUpdate(@RequestBody Supplyadminapply supplyadminapply) {
        if (supplyadminapply.getNeedQuantity() == 0) supplyadminapply.setOutState(true);    //数量为0->分配完毕
        return supplyadminapplyService.updateById(supplyadminapply);
    }

    //获取所有管理员申请
    @GetMapping("/getAll")
    public List<Supplyadminapply> getAll() {
        return supplyadminapplyService.getListByOrder();
    }

}
