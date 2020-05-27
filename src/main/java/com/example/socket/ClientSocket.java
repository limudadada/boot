package com.example.socket;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i=0;i<3;i++){
            Socket sk = new Socket("10.0.60.65", 9999);
            new Thread(new CReceive(sk)).start();
        }

    }
    static class CReceive implements Runnable {
        private Socket sk;
        private PrintWriter pw;
        public CReceive(Socket sk) throws IOException {
            this.sk = sk;
            this.pw = new PrintWriter(sk.getOutputStream(), true);
            pw.println("{\"code\":\"10000\",\"len\":\"10\",\"sn\":\"test01\"}");
        }
        @Override
        public void run() {
            try {
                InputStreamReader isr2 = new InputStreamReader(sk.getInputStream());
                BufferedReader br2 = new BufferedReader(isr2);
                while (true) {
                    // 接受服务端消息
                    String res = br2.readLine();
                    if (StringUtils.isNotBlank(res)) {
                        System.out.println("服务端发送过来数据test:" + res + "............." + Thread.currentThread().getName());
                        pw.println("{\"code\":\"12000\",\"clientResp\":\"050001\"}");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("异常 : " + e);
            }
        }
    }
}
