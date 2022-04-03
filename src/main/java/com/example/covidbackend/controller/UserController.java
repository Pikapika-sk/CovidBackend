package com.example.covidbackend.controller;

import com.example.covidbackend.controller.DTO.UserDTO;
import com.example.covidbackend.entity.User;
import com.example.covidbackend.mapper.UserMapper;
import com.example.covidbackend.service.UserService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping
    public boolean save(@RequestBody User user) { //User对象从接口传过来
        return userService.saveUser(user);
    }

    @PostMapping("/isadmin")
    public boolean isadmin(@RequestBody User user){
        return userService.judgeIsAdmin(user);
    }

    @GetMapping
    public List<User> get() {
        List<User> user = userService.list();
        return user;
    }

    @GetMapping("/{phoneNumber}")
    public User getUserOfSetting(@PathVariable String phoneNumber) {
        return userService.getTheSetUser(phoneNumber);
    }
    @GetMapping("getAddress/{phoneNumber}")
    public User getAddress (@PathVariable String phoneNumber){
        return userService.getAddress(phoneNumber);
    }

    @DeleteMapping("/{id}")
    public boolean remove(@PathVariable Integer id) {
        return userService.removeById(id);
    }
}
