package com.example.covidbackend.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.entity.Supplycategory;
import com.example.covidbackend.entity.User;
import com.example.covidbackend.mapper.SupplycategoryMapper;
import com.example.covidbackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SupplycategoryService extends ServiceImpl<SupplycategoryMapper, Supplycategory> {

    @Autowired
    private SupplycategoryMapper supplycategoryMapper;

    public boolean register(Supplycategory supplycategory) {
        QueryWrapper<Supplycategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("categoryname", supplycategory.getCategoryname());

        Supplycategory one = getOne(queryWrapper);
        if (one == null) {
            one = new Supplycategory();
            BeanUtil.copyProperties(supplycategory, one, true);
            save(one);
            return true;
        } else {
            return false;
        }
    }

    public List<String> getcategory() {
        QueryWrapper<Supplycategory> wrapper = new QueryWrapper<>();
        wrapper.select("categoryname");
        List<Map<String, Object>> maps = supplycategoryMapper.selectMaps(wrapper);
        List<String> ans = new ArrayList<>();
        for (Map<String, Object> m : maps) {
            for (String k : m.keySet()) {
                ans.add((String) m.get(k));
            }
        }
        return ans;
    }

    public List<Supplycategory> getByAllByTime() {
        QueryWrapper<Supplycategory>wrapper= new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return getBaseMapper().selectList(wrapper);
    }
}
