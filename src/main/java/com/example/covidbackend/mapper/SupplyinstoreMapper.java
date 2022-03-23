package com.example.covidbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.covidbackend.entity.Supplyinstore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface SupplyinstoreMapper extends BaseMapper<Supplyinstore> {
}
