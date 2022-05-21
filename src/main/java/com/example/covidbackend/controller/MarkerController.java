package com.example.covidbackend.controller;

import com.example.covidbackend.controller.DTO.MarkerDTO;
import com.example.covidbackend.entity.Marker;
import com.example.covidbackend.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marker")
public class MarkerController {
    @Autowired
    private MarkerService markerService;

    //获得所有申请对应的marker
    @GetMapping("/getAll")
    public List<MarkerDTO> getNeedMarker() {
        return markerService.getNeedMarker();
    }

    //存储marker
    @PostMapping("/save")
    public boolean saveOne(@RequestBody Marker marker) {
        return markerService.save(marker);
    }

}
