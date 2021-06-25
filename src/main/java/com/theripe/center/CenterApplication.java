package com.theripe.center;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.theripe.center.dao")
public class CenterApplication {

    public static void main(String[] args) {

        SpringApplication.run(CenterApplication.class, args);
    }

}
