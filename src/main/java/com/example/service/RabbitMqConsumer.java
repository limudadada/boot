//package com.example.service;
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Map;
//
//@Component
//public class RabbitMqConsumer {
//
//    @RabbitListener(queues = "TestDeadQueue")
//    @RabbitHandler
//    public void process(Map obj, Channel channel, Message message) throws IOException {
//        try {
//            System.out.println("DirectQueue消费者收到消息并NACK返回  : " + obj.toString());
//            channel.basicQos(30);
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (Exception e) {
//            e.printStackTrace();
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//        }
//    }
//
//    @RabbitListener(queues = "DeadQueue")
//    @RabbitHandler
//    public void processDead(Map obj, Channel channel, Message message) throws IOException {
//        try {
//            System.out.println("DeadQueue消费者收到消息并ACK返回  : " + obj.toString());
//            channel.basicQos(30);
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        } catch (Exception e) {
//            e.printStackTrace();
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//        }
//    }
//
//}
