//package com.example.kafka;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaConsumer {
//
//    @KafkaListener(topics = {"test"})
//    public void listener(String message){
//        System.err.println("收到消息："+message);
//    }
//}