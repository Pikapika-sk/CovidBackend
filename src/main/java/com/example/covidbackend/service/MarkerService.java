package com.example.covidbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.controller.DTO.MarkerDTO;
import com.example.covidbackend.entity.Marker;
import com.example.covidbackend.entity.Supplyapproval;
import com.example.covidbackend.entity.User;
import com.example.covidbackend.mapper.MarkerMapper;
import com.example.covidbackend.mapper.SupplyapprovalMapper;
import com.example.covidbackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class MarkerService extends ServiceImpl<MarkerMapper, Marker> {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SupplyapprovalMapper supplyapprovalMapper;

    public List<MarkerDTO> getNeedMarker() {
        /*
        1.获取所有申请中的电话号码
        2.set存储电话号码
        3.通过电话号码查询address
        4.通过地址查询对应marker并返回
         */
        QueryWrapper<Supplyapproval> supplyapprovalQueryWrapper = new QueryWrapper<>();
        supplyapprovalQueryWrapper.select("phone_number");
        ;
        List<Object> approvals = supplyapprovalMapper.selectObjs(supplyapprovalQueryWrapper);
        Set<String> phoneNumbers = new HashSet<>();
        for (Object approval : approvals) {
            phoneNumbers.add(approval.toString());
        }
        Map<String, String> AddressToPhone = new HashMap<>();
        List<String> needAddress = new ArrayList<>();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        for (String oneNumber : phoneNumbers) {
            wrapper.eq("phone_number", oneNumber);
            User user = userMapper.selectById(oneNumber);
            needAddress.add(user.getAddress());
            AddressToPhone.put(user.getAddress(), oneNumber);
        }
        List<MarkerDTO> markers = new ArrayList<>();
        for (String add : needAddress) {
            Marker marker = getBaseMapper().selectById(add);
            MarkerDTO markerDTO = new MarkerDTO();
            markerDTO.setAddress((marker.getAddress()));
            markerDTO.setLat(marker.getLat());
            markerDTO.setLng(marker.getLng());
            markerDTO.setPhoneNumber(AddressToPhone.get(add));
            markers.add(markerDTO);
        }
        return markers;
    }
}
