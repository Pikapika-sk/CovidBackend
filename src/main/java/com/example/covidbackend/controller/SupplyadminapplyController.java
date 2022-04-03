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

    @PostMapping("/set")
    public boolean adminApplySet(@RequestBody Supplyadminapply supplyadminapply){
        supplyadminapply.setNeedQuantity(supplyadminapply.getQuantity());
        return supplyadminapplyService.saveTheApply(supplyadminapply);

    }
    @PostMapping("/update")
    public boolean adminApplyUpdate(@RequestBody Supplyadminapply supplyadminapply){
        if(supplyadminapply.getNeedQuantity()==0)supplyadminapply.setOutState(true);
        return supplyadminapplyService.updateById(supplyadminapply);
    }
    @GetMapping("/getAll")
    public List<Supplyadminapply> getAll(){
        return supplyadminapplyService.list();
    }

}
