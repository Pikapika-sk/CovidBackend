package com.example.covidbackend.controller;


import com.example.covidbackend.Util.UniqueID;
import com.example.covidbackend.entity.Supplyinstore;
import com.example.covidbackend.service.SupplyinstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplyInStore")
public class SupplyinstoreController {

    @Autowired
    private SupplyinstoreService supplyService;
//  物资入库
    @PostMapping("/register")
    public boolean register(@RequestBody Supplyinstore supplyInStore) {
        String tmp = new UniqueID().getTheUniqueId();
        if (supplyInStore.getCategoryname() == null || supplyInStore.getSupplyname() == null || supplyInStore.getQuantity() <= 0)
            return false;
        if (supplyInStore.getNote() == "") supplyInStore.setNote("无");
        supplyInStore.setId(tmp);

        return supplyService.save(supplyInStore);
    }
//  入库信息
    @GetMapping
    public List<Supplyinstore> getAll() {
        return supplyService.getListByOrder();

    }

    @DeleteMapping("{id}")
    public boolean remove(@PathVariable String id) {
        return supplyService.removeById(id);
    }

    @GetMapping ("/getPurpledata")
    public List<Long> getPurpleData(){
        return supplyService.getPurpledata();
    }
    @GetMapping ("/getBluedata")
    public List<Long> getBlueData(){
        return supplyService.getBluedata();
    }
    @GetMapping ("/getSevenDaySum")
    public String getSevenDaySum(){
        return supplyService.getSevenDaySum();
    }

}
