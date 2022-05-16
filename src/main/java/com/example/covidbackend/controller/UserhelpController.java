package com.example.covidbackend.controller;


import com.example.covidbackend.Util.UniqueID;
import com.example.covidbackend.entity.Userhelp;
import com.example.covidbackend.service.UserhelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/userhelp")
public class UserhelpController {
    @Autowired
    private UserhelpService userhelpService;

    @GetMapping("/getAll")
    public List<Userhelp> getall() {
        return userhelpService.getallByTimeOrder();
    }

    @PostMapping("/save")
    public boolean saveOne(@RequestBody Userhelp userhelp) {
        return userhelpService.saveTheHelp(userhelp);
    }

    @PostMapping("/changeState/{id}")
    public boolean changeState(@PathVariable String id) {
        return userhelpService.changeState(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Userhelp userhelp) {
        return userhelpService.updateById(userhelp);
    }

    @DeleteMapping("/delete/{id}")
    public boolean dalete(@PathVariable String id) {
        return userhelpService.removeById(id);
    }

}
