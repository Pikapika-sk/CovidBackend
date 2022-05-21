package com.example.covidbackend.controller;


import com.example.covidbackend.entity.Polygon;
import com.example.covidbackend.service.PolygonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/polygon")
public class PolygonController {
    @Autowired
    private PolygonService polygonService;

    //获取多边形所有坐标点
    @GetMapping("/getAll")
    public List<Polygon> getPolygon() {
        return polygonService.list();
    }

    //存储坐标点
    @PostMapping("/update")
    public Boolean updatePolygon(@RequestBody List<Polygon> polygonList) {
        return polygonService.saveBatch(polygonList);
    }

    //删除原坐标点
    @PostMapping("/delete")
    public boolean DeletePolygon(@RequestBody List<Polygon> polygonList) {
        return polygonService.removeBatchByIds(polygonList);
    }

}
