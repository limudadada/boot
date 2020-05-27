package com.example.netty.client;

public class TestNettyClient {

    public static void main(String[] args) throws InterruptedException {
        //开启10条线程，每条线程就相当于一个客户端
//        for (int i = 1; i <= 10; i++) {
        new Thread(new NettyClient("content start la")).start();
//        Thread.sleep(1000);
//        }
    }
}
