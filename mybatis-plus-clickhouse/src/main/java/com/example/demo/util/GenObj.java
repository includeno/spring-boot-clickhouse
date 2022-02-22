package com.example.demo.util;

import cn.hutool.core.date.DateUtil;
import com.example.demo.entity.User;

import java.util.Date;
import java.util.UUID;

public class GenObj {

    public static User newUser(){
        User user=new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setEmail(UUID.randomUUID().toString());
        user.setPassword("123456sfvdf");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Date today= DateUtil.parse(DateUtil.today()).toJdkDate();
        user.setPartition(today);

        return user;
    }
}
