package com.chenkang.decheng;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.chenkang.decheng.mapper")
public class DechengApplication {

    public static void main(String[] args) {
        SpringApplication.run(DechengApplication.class, args);
    }

}

