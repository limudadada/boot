package com.example;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "freedom")
public class FreedomParam {
    //String ip = "testnidocr.eidlink.com"; //云识读服务IP地址，由云识读服务提供
    //int port = 8080; //云识读服务端口，由云识读服务提供
    //String cId = "1440C00"; //云识读服务分配cid，由云识读服务提供
    //String appId = "TESTID20200412182417"; //云识读服务分配appid，由云识读服务提供
    //String appKey = "7D470E40C2E28DA025BA86E17A85B270"; //云识读服务分配appkey，由云识读服务提供
    private String ipAddr;
    private int port;
    private String cId;
    private String appId;
    private String appKey;
    private String tcpIp;
    private int tcpPort;
}
