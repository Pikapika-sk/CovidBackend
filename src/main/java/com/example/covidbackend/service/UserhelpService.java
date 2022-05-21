package com.example.covidbackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.covidbackend.Util.UniqueID;
import com.example.covidbackend.entity.User;
import com.example.covidbackend.entity.Userhelp;
import com.example.covidbackend.mapper.UserhelpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserhelpService extends ServiceImpl<UserhelpMapper, Userhelp> {

    @Autowired
    private UserService userService;

    public boolean saveTheHelp(Userhelp userhelp) {
        userhelp.setId(new UniqueID().getTheUniqueId());
        userhelp.setState(false);
        userhelp.setCreateTime(new Date());
        User user = userService.getById(userhelp.getPhoneNumber());
        userhelp.setAddress(user.getAddress());
        return save(userhelp);
    }

    public List<Userhelp> getallByTimeOrder() {
        QueryWrapper<Userhelp> userhelpQueryWrapper = new QueryWrapper<>();
        userhelpQueryWrapper.orderByDesc("create_time");
        return list(userhelpQueryWrapper);
    }

    public boolean changeState(String id) {
        Userhelp userhelp = getById(id);
        userhelp.setState(!userhelp.getState());
        return saveOrUpdate(userhelp);
    }
}
