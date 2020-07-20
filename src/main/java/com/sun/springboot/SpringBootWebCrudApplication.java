package com.sun.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootWebCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebCrudApplication.class, args);
    }

}
