package com.example.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/mapper")
public class UserMapperController {
    @Autowired
    UserMapper userMapper;

    public int update(User user){
        //近似唯一id
        int count=userMapper.selectCount(null);
        User temp=userMapper.selectById(count);
        if(temp!=null){
            userMapper.deleteById(user.getId());
        }
        user.setId(count);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Date today= DateUtil.parse(DateUtil.today()).toJdkDate();
        user.setPartition(today);
        return userMapper.insert(user);
    }

    @PostMapping("/user")
    public int insertUser(User user){
        //近似唯一id
        int count=userMapper.selectCount(null);
        User temp=userMapper.selectById(count);
        if(temp!=null){
            userMapper.deleteById(user.getId());
        }
        user.setId(count);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Date today= DateUtil.parse(DateUtil.today()).toJdkDate();
        user.setPartition(today);
        return userMapper.insert(user);
    }

    @GetMapping("/user")
    public User getUser(Integer id){
        return userMapper.selectById(id);
    }
    @PutMapping("/user")
    public int updateUser(User user){
        user.setUpdateTime(new Date());
        return userMapper.updateById(user);
    }

    @DeleteMapping("/user")
    public int deleteUser(User user){
        return userMapper.deleteById(user.getId());
    }
}