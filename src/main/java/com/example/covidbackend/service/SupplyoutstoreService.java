package com.example.covidbackend.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.entity.Supplyinstore;
import com.example.covidbackend.entity.Supplyoutstore;
import com.example.covidbackend.mapper.SupplyoutstoreMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Long> getPurpledata() {
        Date tmptoday = new Date();
        Date today = DateUtil.parse(tmptoday.toString());
        List<Long> list = new ArrayList<>();
        for (int i = 0; i > -7; i--) {
            QueryWrapper<Supplyoutstore> wrapper = new QueryWrapper<>();
            Date nowday = DateUtil.beginOfDay(DateUtil.offsetDay(today, i));
            wrapper.lt("out_time", DateUtil.endOfDay(nowday));
            wrapper.ge("out_time", DateUtil.beginOfDay(nowday));
            List<Supplyoutstore> supplyoutstoreList = getBaseMapper().selectList(wrapper);
            long sum = 0 ;
            for(Supplyoutstore supplyoutstore :supplyoutstoreList){
                sum += supplyoutstore.getOutQuantity();
            }
            list.add(sum);

        }
        return list;
    }

    public String getSevenDaySum() {
        Date tmptoday = new Date();
        Date today = DateUtil.parse(tmptoday.toString());
        Double sum = 0.0;
        QueryWrapper<Supplyoutstore> wrapper = new QueryWrapper<>();
        Date nowdaybeforeseven = DateUtil.beginOfDay(DateUtil.offsetDay(today, -6));
        wrapper.lt("out_time", DateUtil.endOfDay(today));
        wrapper.ge("out_time", DateUtil.beginOfDay(nowdaybeforeseven));
        List<Supplyoutstore> supplyinstores = getBaseMapper().selectList(wrapper);
        for (Supplyoutstore supplyoutstore : supplyinstores) {
            sum += supplyoutstore.getOutQuantity();
        }
        int tmp = sum.intValue();
        return Integer.toString(tmp);
    }

    public List<Supplyoutstore> getlistByOrder() {
        QueryWrapper<Supplyoutstore> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        return getBaseMapper().selectList(wrapper);
    }
}
