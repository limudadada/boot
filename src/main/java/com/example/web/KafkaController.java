//package com.example.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KafkaController {
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    @RequestMapping("message/send")
//    public String send(){
//        kafkaTemplate.send("test", "msg"); //使用kafka模板发送信息
//        return "success";
//    }
//
//}
