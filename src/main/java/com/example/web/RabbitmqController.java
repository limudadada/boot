package com.example.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class RabbitmqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("message/send")
    public void send(){
        String msgId = String.valueOf(UUID.randomUUID());
        String sendTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map = new HashMap<>();
        map.put("person_id", "233434");
        map.put("school_id", "1000");
        map.put("card_no", "CDDDD");
        map.put("media_type","dddddd");
        map.put("person_role","3");
        map.put("business_type","99");

        rabbitTemplate.convertAndSend("materialCardExchange", "materialRoutingKey", JSONObject.toJSONString(map));
    }

}
