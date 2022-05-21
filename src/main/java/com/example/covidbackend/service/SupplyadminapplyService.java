package com.example.covidbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.Util.UniqueID;
import com.example.covidbackend.entity.Supplyadminapply;
import com.example.covidbackend.mapper.SupplyadminapplyMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SupplyadminapplyService extends ServiceImpl<SupplyadminapplyMapper, Supplyadminapply> {

    public boolean saveTheApply(Supplyadminapply supplyadminapply) {
        Supplyadminapply saveapply = new Supplyadminapply();
        saveapply.setAddress(supplyadminapply.getAddress());
        saveapply.setCategoryname(supplyadminapply.getCategoryname());
        saveapply.setNote(supplyadminapply.getNote());
        String id = new UniqueID().getTheUniqueId();
        saveapply.setId(id);
        saveapply.setQuantity(supplyadminapply.getQuantity());
        saveapply.setOutState(false);
        saveapply.setUsername(supplyadminapply.getUsername());
        saveapply.setWeight(supplyadminapply.getWeight());
        saveapply.setCreateTime(new Date());
        saveapply.setNeedQuantity(saveapply.getQuantity());
        return save(saveapply);

    }

    public List<Supplyadminapply> getListByOrder() {
        QueryWrapper<Supplyadminapply> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("out_state").orderByDesc("weight").orderByAsc("create_time");
        return getBaseMapper().selectList(wrapper);
    }
}
