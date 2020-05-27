package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@SpringBootConfiguration
@EnableConfigurationProperties({FreedomParam.class})
@ComponentScan({"com.example.interceptor","com.example.service","com.example.netty.runner","com.example.web","com.example.configuration"})
public class BootoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootoneApplication.class, args);
    }

}
