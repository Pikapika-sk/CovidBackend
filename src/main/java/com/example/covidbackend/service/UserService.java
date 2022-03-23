package com.example.covidbackend.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.controller.DTO.UserDTO;
import com.example.covidbackend.entity.User;
import com.example.covidbackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public boolean saveUser(User user) {
        return saveOrUpdate(user);
    }


    public boolean login(UserDTO userDTO) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("phone_number", userDTO.getPhoneNumber());//这里的column要跟数据库的列一样
        queryWrapper.eq("password", userDTO.getPassword());
        try {
            User one = getOne(queryWrapper);
            return one != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean register(UserDTO userDTO) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("phone_number", userDTO.getPhoneNumber());

        User one = getOne(queryWrapper);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);
            save(one);
            return true;
        } else {
            return false;
        }

    }

}