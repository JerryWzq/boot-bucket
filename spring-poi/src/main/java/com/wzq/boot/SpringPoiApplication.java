package com.wzq.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wzq.boot.mapper")
public class SpringPoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPoiApplication.class, args);
    }

}
