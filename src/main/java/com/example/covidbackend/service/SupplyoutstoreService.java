package com.example.covidbackend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.entity.Supplyoutstore;
import com.example.covidbackend.mapper.SupplyoutstoreMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyoutstoreService extends ServiceImpl<SupplyoutstoreMapper, Supplyoutstore> {
    public Integer getOutSum() {
        int sum = 0 ;
        List<Supplyoutstore> supplyoutstoreList = list();
        for( Supplyoutstore supplyoutstore : supplyoutstoreList){
            sum += supplyoutstore.getOutQuantity();
        }
        return sum;
    }
}
