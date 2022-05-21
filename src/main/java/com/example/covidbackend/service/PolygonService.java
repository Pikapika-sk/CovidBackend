package com.example.covidbackend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.entity.Polygon;
import com.example.covidbackend.mapper.PolygonMapper;
import org.springframework.stereotype.Service;

@Service
public class PolygonService extends ServiceImpl<PolygonMapper, Polygon> {

}
