//package com.example.netty.runner;
//
//import com.example.netty.server.NettyServer;
//import com.example.service.FreedomReadCardService;
//import com.example.service.TestFreedomService;
//import com.example.socket.ServerTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.InetSocketAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//@Component
//public class StartRunner implements CommandLineRunner {
//
//    //    @Resource
////    private FreedomReadCardService freedomReadCardService;
////    @Autowired
////    private NettyServer nettyServer;
//    @Resource
//    private TestFreedomService testFreedomService;
//
////    public static PrintWriter pw;
//
//
////    public void initServer() throws IOException {
////        ServerSocket ss = new ServerSocket(9999);
////        s = ss.accept();
////        pw = new PrintWriter(s.getOutputStream(), true);
////    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        ServerSocket ss = new ServerSocket(9999);
//        while (true) {
//            Socket s = ss.accept();
//            new Thread(new SReceive(s)).start();
//        }
//
////        this.initServer();
//
//
////        System.out.println("dddddddffff");
////        ServerSocket ss = new ServerSocket(9999);
////        System.out.println("开启serversocket");
////        while (true) {
////            Socket socket = ss.accept();
////            System.out.println(socket.getInetAddress() + "................." + socket.getPort());
////            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
////            BufferedReader br = new BufferedReader(isr);
////            // 阻塞
//////            while (true) {
////            String clientResp = br.readLine();
////            System.out.println("客户端发送过来数据: " + clientResp);
////            // 客户端操作关闭服务端
////            if (clientResp.equals("close")) {
////                testFreedomService.beginReadcard("G10", "G10", 10, socket, clientResp);
////            }
//////            }
////
////        }
//
//
////        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8888);
////        nettyServer.start(inetSocketAddress);
////        System.out.println("服务启动");
//
//    }
//
//    class SReceive implements Runnable {
//
//        private Socket socket;
//
//        SReceive(Socket socket) {
//            this.socket = socket;
//        }
//
//        @Override
//        public void run() {
//            try {
//                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
//                BufferedReader br = new BufferedReader(isr);
//                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
//                // 阻塞
////                while (true) {
//                String clientResp = br.readLine();
//                if (StringUtils.hasText(clientResp))
//                    System.out.println("客户端发送过来数据: " + clientResp + "........" + Thread.currentThread().getName());
//                if ("close".equals(clientResp)) {
//                    testFreedomService.beginReadcard("fid", "fid", 3, br, pw);
//                }
//                // 客户端操作关闭服务端
//
////                }
//            } catch (Exception e) {
//                System.out.println("异常 : " + e);
//            }finally {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
