//package com.example.service;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@Component
//public class FreedomInitServerSocket implements CommandLineRunner {
//
//    @Resource
//    FreedomReadCardService freedomReadCardService;
//
//    @Override
//    public void run(String... strings) throws Exception {
//        log.info(".............FreedomInitServerSocket..start.............");
//        ServerSocket ss = new ServerSocket(9999);
//        while (true) {
//            Socket s = ss.accept();
//            log.info("freedomInitServerSocket socket client is {}", s.getInetAddress());
//            new Thread(new SReceive(s)).start();
//        }
//    }
//
//    class SReceive implements Runnable {
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
//                while (true) {
//                    String clientResp = br.readLine();
//                    if (StringUtils.hasText(clientResp)) {
//                        log.info("receive socketClient message is {}", clientResp);
//                        Map<String,Object> map = new HashMap<>();
//                        map.put("code","11000");
//                        map.put("result","ddddddd");
//                        pw.println(JSONObject.toJSONString(map));
//                        pw.flush();
//                        Map clientMap = JSON.parseObject(clientResp, Map.class);
//                        if (clientMap != null) {
//                            String code = String.valueOf(clientMap.get("code"));
//                            if (FreedomConstant.FREEDOM_SK_CODE.equalsIgnoreCase(code)) {
//                                String sn = String.valueOf(clientMap.get("sn"));
//                                int len = Integer.valueOf(String.valueOf(clientMap.get("len")));
//                                if (StringUtils.hasText(sn) && len > 0){
//                                    freedomReadCardService.beginReadcard(sn,sn,len,br,pw);
//                                }
//                            }
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                log.error("FreedomInitServerSocket error",e);
//            }finally {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    log.error("socket close error",e);
//                }
//            }
//        }
//    }
//}
