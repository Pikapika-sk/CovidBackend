package com.example.covidbackend.controller;

import com.example.covidbackend.controller.DTO.UrgencyDTO;
import com.example.covidbackend.entity.Urgency;
import com.example.covidbackend.service.UrgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/urgency")
public class UrgencyController {

    @Autowired
    private UrgencyService urgencyService;

    //存储紧急事项
    @PostMapping("/set")
    public boolean setUrgent(@RequestBody UrgencyDTO urgencyDTO) {
        return urgencyService.saveFromDTO(urgencyDTO);
    }

    //获取所有紧急事项列表
    @GetMapping("/getall")
    public List<Urgency> getAllUrgency() {
        return urgencyService.list();
    }

    //获取个人所申请的紧急事项
    @GetMapping("/{phoneNumber}")
    public Urgency getUrgency(@PathVariable String phoneNumber) {
        return urgencyService.getById(phoneNumber);
    }

    //删除紧急事项
    @DeleteMapping("/{phoneNumber}")
    public boolean deleteUrgency(@PathVariable String phoneNumber) {
        return urgencyService.removeById(phoneNumber);
    }

    //改变紧急事项状态
    @PostMapping("/changestate")
    public boolean changestate(@RequestBody Urgency urgency) {
        return urgencyService.saveOrUpdate(urgency);
    }

    //获取紧急事项总数
    @GetMapping("/sum")
    public Integer getThesum() {
        return urgencyService.getTheSum();
    }

    //获取未处理的紧急事项
    @GetMapping("/getallnofinish")
    public List<Urgency> getallno() {
        return urgencyService.getalllno();
    }
}
