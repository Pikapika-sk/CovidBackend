package com.example.covidbackend.controller;

import com.example.covidbackend.controller.DTO.MarkerDTO;
import com.example.covidbackend.entity.Marker;
import com.example.covidbackend.entity.User;
import com.example.covidbackend.service.MarkerService;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marker")
public class MarkerController {
    @Autowired
    private MarkerService markerService;

    @GetMapping ("/getAll")
    public List<MarkerDTO> getNeedMarker(){
        return markerService.getNeedMarker();
    }
    @PostMapping("/save")
    public boolean saveOne(@RequestBody Marker marker){
        return markerService.save(marker);
    }

}
