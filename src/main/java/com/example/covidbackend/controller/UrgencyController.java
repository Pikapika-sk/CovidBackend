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

    @PostMapping("/set")
    public boolean setUrgent(@RequestBody UrgencyDTO urgencyDTO){

        return urgencyService.saveFromDTO(urgencyDTO);
    }

    @GetMapping("/getall")
    public List<Urgency> getAllUrgency(){
        return urgencyService.list();
    }
    @GetMapping("/{phoneNumber}")
    public Urgency getUrgency(@PathVariable String phoneNumber){
        return urgencyService.getById(phoneNumber);

    }
    @DeleteMapping("/{phoneNumber}")
    public boolean deleteUrgency(@PathVariable String phoneNumber){
        return urgencyService.removeById(phoneNumber);
    }

    @PostMapping("/changestate")
    public boolean changestate(@RequestBody Urgency urgency){
        return urgencyService.saveOrUpdate(urgency);
    }

}
