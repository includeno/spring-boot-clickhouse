package com.example.demo.service;

import com.example.demo.ServerApplication;
import com.example.demo.entity.User;
import com.example.demo.util.GenObj;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes = ServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void saveBatch(){
        System.out.println("test");
        List<User> userList=new ArrayList<>();
        int number=20;
        for(int i=0;i<number;i++){
            User t=GenObj.newUser();
            t.setId(i);
            userList.add(t);
        }
        int size=userList.size();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<size;i++){
            User t=User.copy(userList.get(i));
            t.setCreateTime(new Date());
            t.setUpdateTime(new Date());
            userList.add(t);
        }
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<size;i++){
            User t=User.copy(userList.get(i));
            t.setCreateTime(new Date());
            t.setUpdateTime(new Date());
            userList.add(t);
        }

        userService.saveBatch(userList);
    }
}