//package com.example.configuration;
//
//import lombok.Data;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@ConfigurationProperties(prefix = "redis")
//@Data
//@Configuration
//public class RedissonClientConfig {
//
//    private String host;
//
//    private int port;
//
//    @Bean
//    public RedissonClient getRedisson(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://" + host + ":" + port).setDatabase(0);
//        return Redisson.create(config);
//    }
//
//}
