package com.example.covidbackend.controller;

import com.example.covidbackend.controller.DTO.UserDTO;
import com.example.covidbackend.entity.User;
import com.example.covidbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/login")
    public boolean login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    //注册
    @PostMapping("/register")
    public boolean register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    //管理员修改
    @PostMapping
    public boolean save(@RequestBody User user) {
        if (user.getPeopleNumber() < 0) return false;
        return userService.saveUser(user);
    }

    //是否为管理员，页面跳转判定
    @PostMapping("/isadmin")
    public boolean isadmin(@RequestBody User user) {
        return userService.judgeIsAdmin(user);
    }

    //改变用户权限
    @PostMapping("/changeAdmin")
    public boolean changeAdminState(@RequestBody String phoneNumber) {
        return userService.changeState(phoneNumber);
    }

    //获取所有用户列表
    @GetMapping
    public List<User> get() {
        return userService.list();
    }

    //新增用户
    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    //修改用户
    @GetMapping("/{phoneNumber}")
    public User getUserOfSetting(@PathVariable String phoneNumber) {
        return userService.getTheSetUser(phoneNumber);
    }

    //获取用户对应地址信息
    @GetMapping("getAddress/{phoneNumber}")
    public User getAddress(@PathVariable String phoneNumber) {
        return userService.getAddress(phoneNumber);
    }

    //删除用户
    @DeleteMapping("/{phoneNumber}")
    public boolean remove(@PathVariable String phoneNumber) {
        return userService.removeById(phoneNumber);
    }

    //获取用户总数
    @GetMapping("/sum")
    public Integer getTheNumberOfUser() {
        List<User> users = userService.list();
        return users.size();
    }
}

