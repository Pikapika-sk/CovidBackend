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

    @PostMapping("/login")
    public boolean login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping
    public boolean save(@RequestBody User user) {
        if(user.getPeopleNumber()<0)return false;
        return userService.saveUser(user);
    }

    @PostMapping("/isadmin")
    public boolean isadmin(@RequestBody User user){
        return userService.judgeIsAdmin(user);
    }
    @PostMapping("/changeAdmin")
    public boolean changeAdminState(@RequestBody String phoneNumber){
        return userService.changeState(phoneNumber);
    }
    @GetMapping
    public List<User> get() {
        List<User> user = userService.list();
        return user;
    }
    @PostMapping("/add")
    public boolean addUser(@RequestBody User user){
        return  userService.addNewUser(user);
    }
    @GetMapping("/{phoneNumber}")
    public User getUserOfSetting(@PathVariable String phoneNumber) {
        return userService.getTheSetUser(phoneNumber);
    }
    @GetMapping("getAddress/{phoneNumber}")
    public User getAddress (@PathVariable String phoneNumber){
        return userService.getAddress(phoneNumber);
    }

    @DeleteMapping("/{phoneNumber}")
    public boolean remove(@PathVariable String phoneNumber) {
        return userService.removeById(phoneNumber);
    }

    @GetMapping("/sum")
    public  Integer getTheNumberOfUser(){
        List<User> users = userService.list();
        return users.size();
    }
}
