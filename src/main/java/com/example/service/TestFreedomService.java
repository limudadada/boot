package com.example.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Service
public class TestFreedomService {

    public interface LgetLib {
        interface MyCallBack {
            String readCard(String fid, String tidid, String resp);
        }
    }

    public void beginReadcard(String fid, String tidid, int len, BufferedReader br,PrintWriter pw) {
        try {
            FreedomReadCardService.LgetLib.MyCallback mycall = new FreedomReadCardService.LgetLib.MyCallback() {
                @Override
                public String readCard(String fid, String tidid, String resp) {
                    try {
                        System.out.println("beginread----"+"........."+Thread.currentThread().getName());
                        pw.println("ceshi"+".........."+Thread.currentThread().getName());
                        // 阻塞
                        String clientResp = br.readLine();
                        System.out.println("clientResp:-->"+clientResp+"........."+Thread.currentThread().getName());
                        return clientResp;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return "fid";
                }
            };
            String cliresp = mycall.readCard(fid, tidid, "clientRespioio");
            System.out.println("mycallResp:"+cliresp+"........."+Thread.currentThread().getName());
            if (cliresp.contains("haha")){
                pw.println("uuid"+".............."+Thread.currentThread().getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
