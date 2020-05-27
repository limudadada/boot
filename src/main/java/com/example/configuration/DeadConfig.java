package com.example.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DeadConfig {
    @Bean
    public Queue testDeadQueue() {
        Map<String, Object> params = new HashMap<>();
//        params.put("x-dead-letter-routing-key", "DeadRouting");
//        params.put("x-message-ttl", 6 * 60 * 60 * 1000);
//        params.put("x-expires", 6 * 60 * 60 * 1000);
//        params.put("x-dead-letter-exchange", "DeadExchange");
//        params.put()
        return new Queue("materialQueue", true, false, false);
    }

    @Bean
    DirectExchange testDeadExchange() {
        return new DirectExchange("materialCardExchange");
    }

    @Bean
    Binding bindingTestDeadQueue() {
        return BindingBuilder.bind(testDeadQueue()).to(testDeadExchange()).with("materialRoutingKey");
    }

//    @Bean
//    public Queue deadQueue() {
//        Map<String, Object> params = new HashMap<>();
//        params.put("x-message-ttl", 6 * 60 * 60 * 1000);
//        params.put("x-expires", 6 * 60 * 60 * 1000);
//        return new Queue("DeadQueue", true,false,false,params);
//    }
//
//    @Bean
//    DirectExchange deadExchange() {
//        return new DirectExchange("DeadExchange");
//    }
//
//    @Bean
//    Binding bindingDeadQueue() {
//        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("materialRoutingKey");
//    }
}
