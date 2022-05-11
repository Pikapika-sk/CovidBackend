package com.example.covidbackend.controller;

import com.example.covidbackend.Util.UniqueID;
import com.example.covidbackend.controller.DTO.SupplyApprovalDTO;
import com.example.covidbackend.entity.Supplyapproval;
import com.example.covidbackend.service.SupplyapprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/approval")
public class SupplyapprovalController {
    @Autowired
    SupplyapprovalService supplyapprovalService;

    @GetMapping
    public List<Supplyapproval> getAll() {
        return supplyapprovalService.getAllByOrder();
    }

    @GetMapping("/getstate3")
    public List<Supplyapproval> getstate3() {
        return supplyapprovalService.getstate3();
    }

    @PostMapping("/weight")
    public boolean editWeight(@RequestBody Supplyapproval newWeight) {
        return supplyapprovalService.updateById(newWeight);
    }

    @PostMapping("/state2/{id}")
    public boolean update2(@PathVariable String id) {
        Supplyapproval supplyapproval = new Supplyapproval();
        supplyapproval.setId(id);
        supplyapproval.setState(2);
        return supplyapprovalService.updateById(supplyapproval);
    }

    @PostMapping("/state3/{id}")
    public boolean update3(@PathVariable String id) {
        Supplyapproval supplyapproval = new Supplyapproval();
        supplyapproval.setId(id);
        supplyapproval.setState(3);

        return supplyapprovalService.updateById(supplyapproval);
    }

    @GetMapping("/{phoneNumber}")
    public List<Supplyapproval> getself(@PathVariable String phoneNumber) {
        return supplyapprovalService.getself(phoneNumber);
    }

    @PostMapping("/submit")
    public boolean postApply(@RequestBody SupplyApprovalDTO supplyApprovalDTO) {
        Supplyapproval supplyapproval = new Supplyapproval();
        UniqueID uniqueID = new UniqueID();
        supplyapproval.setId(uniqueID.getTheUniqueId());
        supplyapproval.setPhoneNumber(supplyApprovalDTO.getPhoneNumber());
        supplyapproval.setQuantity(supplyApprovalDTO.getQuantity());
        supplyapproval.setCategoryname(supplyApprovalDTO.getCategoryname());
        supplyapproval.setReason(supplyApprovalDTO.getReason());
        supplyapproval.setCreateTime(new Date());
        supplyapproval.setState(1);
        supplyapproval.setWeight(1);
        supplyapproval.setNeedQuantity(supplyApprovalDTO.getQuantity());
        if (supplyApprovalDTO.getQuantity() < 0) return false;
        return supplyapprovalService.save(supplyapproval);
    }

    @PostMapping("/updateofdis")
    public boolean updateOfDis(@RequestBody Supplyapproval supplyapproval) {
        if (supplyapproval.getNeedQuantity() == 0) supplyapproval.setOutState(true);
        return supplyapprovalService.updateById(supplyapproval);
    }

    @GetMapping("/unFinishedSum")
    public String getunFinishedSum() {
        return supplyapprovalService.getunFinishedSum();
    }
}
