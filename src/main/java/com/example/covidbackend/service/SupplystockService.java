package com.example.covidbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.entity.Supplyinstore;
import com.example.covidbackend.entity.Supplystock;
import com.example.covidbackend.mapper.SupplystockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplystockService extends ServiceImpl<SupplystockMapper, Supplystock> {

    @Autowired
    private SupplystockMapper supplystockMapper;
    public List<Supplystock> getofCategory(String categoryname) {

        QueryWrapper<Supplystock>wrapper = new QueryWrapper<>();
        wrapper.eq("categoryname",categoryname);
        List<Supplystock> list =  new ArrayList<>();
        list = supplystockMapper.selectList(wrapper);
        return list;

    }
}
