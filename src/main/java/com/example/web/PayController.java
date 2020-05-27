package com.example.web;

import com.alibaba.fastjson.JSONObject;
import com.example.configuration.PayConfig;
import com.example.model.PayModel;
import com.example.util.HttpClientUtil;
import com.example.util.HttpRequestResult;
import com.example.util.PKCSTool;
import com.example.util.PaymentEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PayController {

//    @Autowired
//    private PayConfig payConfig;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/pay")
    public String pay() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            PayModel payModel = new PayModel();
            payModel.setOrderNo("348934893489");
            payModel.setOrderTime(simpleDateFormat.format(new Date()));
            payModel.setCurCode("001");
            payModel.setOrderAmount("20.07");
            payModel.setMerchantNo("104320553990088");
            payModel.setOrderNote("100002");

            logger.info("pay param is {}", JSONObject.toJSONString(payModel));
//            logger.info("payConfig is {}",JSONObject.toJSONString(payConfig));
            StringBuilder plainTextBuilder = new StringBuilder();
            plainTextBuilder.append(payModel.getOrderNo()).append("|")
                    .append(payModel.getOrderTime()).append("|")
                    .append(payModel.getCurCode()).append("|")
                    .append(payModel.getOrderAmount()).append("|")
                    .append(payModel.getMerchantNo());

            String plainText = plainTextBuilder.toString();
            logger.info("[plainText]=[" + plainText + "]");
            byte plainTextByte[] = plainText.getBytes("UTF-8");
            //获取私钥证书
            PKCSTool tool = PKCSTool.getSigner("/Users/admin/Downloads/jar/95566SZ010000797.pfx", "1111111a", "1111111a", "PKCS7");
            //签名
            String signData = tool.p7Sign(plainTextByte);

            Map<String,String> map = new HashMap<>();
            map.put("merchantNo", payModel.getMerchantNo());
            map.put("payType", "1");
            map.put("orderNo", payModel.getOrderNo());
            map.put("curCode", payModel.getCurCode());
            map.put("orderAmount", payModel.getOrderAmount());
            map.put("orderTime", payModel.getOrderTime());
            map.put("orderNote", payModel.getOrderNote());
            map.put("orderUrl", "http://www.ceshi.com");
            map.put("signData", signData);
            map.put("terminalChnl","08");
//            map.put("action", "https://101.231.206.170:443/PGWPortal/B2CMobileRecvOrder.do");
            System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1,SSLv3");
            HttpRequestResult httpRequestResult = HttpClientUtil.doPostData("https://101.231.206.170:443/PGWPortal/B2CMobileRecvOrder.do",map);
            logger.info("HttpRequestResult is {}",JSONObject.toJSONString(httpRequestResult));
        } catch (Exception e) {
            logger.error("pay error",e);
        }
        return null;
    }
}
