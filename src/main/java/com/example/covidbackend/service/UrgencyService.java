package com.example.covidbackend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.entity.Urgency;
import com.example.covidbackend.mapper.UrgencyMapper;
import org.springframework.stereotype.Service;

@Service
public class UrgencyService extends ServiceImpl<UrgencyMapper, Urgency> {
}
