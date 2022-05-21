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

    //获取所有申请
    @GetMapping
    public List<Supplyapproval> getAll() {
        return supplyapprovalService.getAllByOrder();
    }
    //获取审核通过的申请
    @GetMapping("/getstate3")
    public List<Supplyapproval> getstate3() {
        return supplyapprovalService.getstate3();
    }

    //更新申请权重
    @PostMapping("/weight")
    public boolean editWeight(@RequestBody Supplyapproval newWeight) {
        return supplyapprovalService.updateById(newWeight);
    }

    //审核不通过
    @PostMapping("/state2/{id}")
    public boolean update2(@PathVariable String id) {
        Supplyapproval supplyapproval = new Supplyapproval();
        supplyapproval.setId(id);
        supplyapproval.setState(2);
        return supplyapprovalService.updateById(supplyapproval);
    }

    //审核通过
    @PostMapping("/state3/{id}")
    public boolean update3(@PathVariable String id) {
        Supplyapproval supplyapproval = new Supplyapproval();
        supplyapproval.setId(id);
        supplyapproval.setState(3);
        return supplyapprovalService.updateById(supplyapproval);
    }

    //获得用户自己的的申请列表
    @GetMapping("/{phoneNumber}")
    public List<Supplyapproval> getself(@PathVariable String phoneNumber) {
        return supplyapprovalService.getself(phoneNumber);
    }

    //存储用户申请
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

    //更新申请状态（是否分配完毕）
    @PostMapping("/updateofdis")
    public boolean updateOfDis(@RequestBody Supplyapproval supplyapproval) {
        if (supplyapproval.getNeedQuantity() == 0) supplyapproval.setOutState(true);
        return supplyapprovalService.updateById(supplyapproval);
    }

    //获取未分配完毕申请情况
    @GetMapping("/unFinishedSum")
    public String getunFinishedSum() {
        return supplyapprovalService.getunFinishedSum();
    }
}
