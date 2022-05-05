package com.example.covidbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.controller.DTO.UrgencyDTO;
import com.example.covidbackend.entity.Urgency;
import com.example.covidbackend.mapper.UrgencyMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UrgencyService extends ServiceImpl<UrgencyMapper, Urgency> {
    public boolean saveFromDTO(UrgencyDTO urgencyDTO) {
        QueryWrapper<Urgency> wrapper = new QueryWrapper<>();
        wrapper.eq("phone_number", urgencyDTO.getPhoneNumber());
        Urgency haveUrgency = getOne(wrapper);
        if (haveUrgency != null || urgencyDTO.getContent() == null) return false;
        Urgency urgency = new Urgency();
        urgency.setContent(urgencyDTO.getContent());
        urgency.setPhoneNumber(urgencyDTO.getPhoneNumber());
        urgency.setState(false);
        Date date = new Date();
        urgency.setCreateTime(date);
        return save(urgency);
    }

    public Integer getTheSum() {
        QueryWrapper<Urgency> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",0);
        List<Urgency> urgencies = getBaseMapper().selectList(queryWrapper);
        return urgencies.size();

    }

    public List<Urgency> getalllno() {
        QueryWrapper<Urgency> wrapper = new QueryWrapper<>();
        wrapper.eq("state",0);
        List<Urgency> urgencies = getBaseMapper().selectList(wrapper );
        return urgencies;
    }
}
