package com.example.covidbackend.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.entity.Supplycategory;
import com.example.covidbackend.entity.User;
import com.example.covidbackend.mapper.SupplycategoryMapper;
import com.example.covidbackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class SupplycategoryService extends ServiceImpl<SupplycategoryMapper, Supplycategory> {

    public boolean register(Supplycategory supplycategory) {
        QueryWrapper<Supplycategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("categoryname",supplycategory.getCategoryname());

        Supplycategory one = getOne(queryWrapper);
        if(one ==null){
            one = new Supplycategory();
            BeanUtil.copyProperties(supplycategory,one,true);
            save(one);
            return true;
        }else{
            return false;
        }
    }
}
