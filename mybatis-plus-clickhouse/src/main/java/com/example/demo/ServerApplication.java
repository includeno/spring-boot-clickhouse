package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@MapperScan("com.example.demo.mapper")
@SpringBootApplication
@Slf4j
public class ServerApplication {

    public static void main(String[] args) {
        log.info("system args:"+ Arrays.toString(args));
        SpringApplication.run(ServerApplication.class,args);
    }
}
