package com.example.covidbackend.controller;


import com.example.covidbackend.entity.Userhelp;
import com.example.covidbackend.service.UserhelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/userhelp")
public class UserhelpController {
    @Autowired
    private UserhelpService userhelpService;

    //获取所有用户互助信息
    @GetMapping("/getAll")
    public List<Userhelp> getall() {
        return userhelpService.getallByTimeOrder();
    }

    //存储互助信息
    @PostMapping("/save")
    public boolean saveOne(@RequestBody Userhelp userhelp) {
        return userhelpService.saveTheHelp(userhelp);
    }

    //修改互助信息状态
    @PostMapping("/changeState/{id}")
    public boolean changeState(@PathVariable String id) {
        return userhelpService.changeState(id);
    }

    //更新互助信息
    @PostMapping("/update")
    public boolean update(@RequestBody Userhelp userhelp) {
        return userhelpService.updateById(userhelp);
    }

    //删除互助信息
    @DeleteMapping("/delete/{id}")
    public boolean daleteHelp(@PathVariable String id) {
        return userhelpService.removeById(id);
    }

}
