package com.example.covidbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.Util.UniqueID;
import com.example.covidbackend.controller.DTO.SupplyApprovalDTO;
import com.example.covidbackend.entity.Supplyapproval;
import com.example.covidbackend.mapper.SupplyapprovalMapper;
import com.example.covidbackend.mapper.SupplycategoryMapper;
import com.example.covidbackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyapprovalService extends ServiceImpl<SupplyapprovalMapper, Supplyapproval> {

    @Autowired
    private SupplyapprovalMapper supplyapprovalMapper;
    public List<Supplyapproval> getself(String phoneNumber) {
        QueryWrapper<Supplyapproval>wrapper = new QueryWrapper<>();
        wrapper.eq("phone_number",phoneNumber);
        List<Supplyapproval> supplyapprovals = supplyapprovalMapper.selectList(wrapper);
        return supplyapprovals;
    }

    public String getunFinishedSum() {
        QueryWrapper<Supplyapproval>wrapper =new QueryWrapper<>();
        wrapper.eq("state",1);
        List<Supplyapproval>supplyapprovals = supplyapprovalMapper.selectList(wrapper);
        Integer sum = supplyapprovals.size();
        return sum.toString();
    }

    public List<Supplyapproval> getstate3() {
        QueryWrapper<Supplyapproval>wrapper = new QueryWrapper<>();
        wrapper.eq("state",3);
        List<Supplyapproval>supplyapprovals = supplyapprovalMapper.selectList(wrapper);
        return supplyapprovals;
    }
}
