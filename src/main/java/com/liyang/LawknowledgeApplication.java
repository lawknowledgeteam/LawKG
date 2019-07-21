package com.liyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liyang.mapper")
public class LawknowledgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LawknowledgeApplication.class, args);
    }

}
