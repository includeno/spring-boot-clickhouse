package com.example.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/service")
public class UserServiceController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public boolean insertUser(User user){
        int count=userService.count();
        User temp=userService.getById(count);
        if(temp!=null){
            userService.removeById(user.getId());
        }
        user.setId(count);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Date today=DateUtil.parse(DateUtil.today()).toJdkDate();
        user.setPartition(today);
        return userService.save(user);

    }
    @GetMapping("/user")
    public User getUser(Integer id){
        return userService.getById(id);
    }
    @PutMapping("/user")
    public boolean updateUser(User user){
        user.setUpdateTime(new Date());
        return userService.updateById(user);
    }
    @DeleteMapping("/user")
    public boolean deleteUser(User user){
        return userService.removeById(user.getId());
    }
}