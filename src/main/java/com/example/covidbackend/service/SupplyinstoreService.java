package com.example.covidbackend.service;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.CovidBackendApplication;
import com.example.covidbackend.entity.Supplyinstore;
import com.example.covidbackend.mapper.SupplyinstoreMapper;
import com.example.covidbackend.mapper.SupplystockMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupplyinstoreService extends ServiceImpl<SupplyinstoreMapper, Supplyinstore> {


    public List<Long> getPurpledata() {
        Date tmptoday = new Date();
        Date today = DateUtil.parse(tmptoday.toString());
        List<Long> list = new ArrayList<>();
        for (int i = 0; i > -7; i--) {
            QueryWrapper<Supplyinstore> wrapper = new QueryWrapper<>();
            Date nowday = DateUtil.beginOfDay(DateUtil.offsetDay(today, i));
            wrapper.lt("in_store_time", DateUtil.endOfDay(nowday));
            wrapper.ge("in_store_time", DateUtil.beginOfDay(nowday));
            list.add(getBaseMapper().selectCount(wrapper));
        }
        return list;
    }

    public String getSevenDaySum() {
        Date tmptoday = new Date();
        Date today = DateUtil.parse(tmptoday.toString());
        Double sum = 0.0;
        QueryWrapper<Supplyinstore> wrapper = new QueryWrapper<>();
        Date nowdaybeforeseven = DateUtil.beginOfDay(DateUtil.offsetDay(today, -6));
        wrapper.lt("in_store_time", DateUtil.endOfDay(today));
        wrapper.ge("in_store_time", DateUtil.beginOfDay(nowdaybeforeseven));
        List<Supplyinstore> supplyinstores = getBaseMapper().selectList(wrapper);
        for (Supplyinstore supplyinstore : supplyinstores) {
            sum += supplyinstore.getQuantity();
        }
       int tmp = sum.intValue();
        return Integer.toString(tmp);

    }

    public List<Long> getBluedata() {
        Date tmptoday = new Date();
        Date today = DateUtil.parse(tmptoday.toString());
        List<Long> list = new ArrayList<>();
        for (int i = 0; i > -7; i--) {
            QueryWrapper<Supplyinstore> wrapper = new QueryWrapper<>();
            Date nowday = DateUtil.beginOfDay(DateUtil.offsetDay(today, i));
            wrapper.lt("in_store_time", DateUtil.endOfDay(nowday));
            wrapper.ge("in_store_time", DateUtil.beginOfDay(nowday));
            List<Supplyinstore> supplyinstores = getBaseMapper().selectList(wrapper);
            long sum = 0;
            for(Supplyinstore supplyinstore :supplyinstores){
                sum += supplyinstore.getQuantity().longValue();
            }
            list.add(sum);
        }
        return list;
    }
}
