package com.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static PrintWriter pw;
    public static Socket s;

    public void initServer() throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        s = ss.accept();
        pw = new PrintWriter(s.getOutputStream(), true);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerTest serverTest = new ServerTest();
        serverTest.initServer();
        new Thread(new SReceive()).start();
        pw.println("服务端发送的消息");
    }


    static class SReceive implements Runnable {
        @Override
        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(s.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                // 阻塞
                while (true) {
                    String clientResp = br.readLine();
                    System.out.println("客户端发送过来数据: " + clientResp);
                    // 客户端操作关闭服务端
                    if (clientResp.equals("close")) {
                        s.close();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("异常 : " + e);
            }
        }
    }
}
