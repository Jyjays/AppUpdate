package com.appup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.appup.mapper")
@SpringBootApplication
@ServletComponentScan("com.appup.filter")
public class AppUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppUpApplication.class, args);
    }

}
