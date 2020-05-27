package com.example.service;

/***
 * 读卡实现类
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eidlink.idocr.sdk.constants.PublicParam;
import com.eidlink.idocr.sdk.pojo.request.IdCardCheckParam;
import com.eidlink.idocr.sdk.pojo.result.CommonResult;
import com.eidlink.idocr.sdk.service.EidlinkService;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class FreedomReadCardService {


    public interface LgetLib extends Library {
        //eid_V3.0.9,so文件默认路径放到/lib64目录下
        LgetLib INSTANCE = (LgetLib) Native.loadLibrary("eid", LgetLib.class);

        int JLRCs(String cid, String fdid, String tdid, byte[] reqid, int len,
                  int declevel, MyCallback treadCard, int loglvel);

        interface MyCallback extends Callback {
            String readCard(String fid, String tidid, String resp);
        }
    }

    public void beginReadcard(String fid, String tidid, int len, BufferedReader br, PrintWriter pw) {
        log.info("FreedomReadCardService freedomParam is {}",fid);
        LgetLib.MyCallback mycall = new LgetLib.MyCallback() {
            /*
             * (non-Javadoc)
             * @see com.eidlink.test.readcard.ReadCardImp.LgetLib.MyCallback#readCard(java.lang.String, java.lang.String, java.lang.String)
             * resp  读卡指令数据`
             * fid  客户端标识
             * tidid 与fid一致，应用可以自定义
             */
            @Override
            public String readCard(String fid, String tidid, String resp) {
                log.info("FreedomReadCardService readCard fid is {},tidid is {},resp is {}", fid, tidid, resp);
                /**
                 * 此处用户实现与客户端交互代码，将resp读卡指令下发给客户端，
                 * 客户端返回数据在return,目前通过socket的形式发给客户端。
                 */
                try {
                    Map<String, Object> q = new HashMap<>();
                    q.put("code", FreedomConstant.FREEDOM_RESP_CODE);
                    q.put("resp", resp);
                    pw.println(JSONObject.toJSONString(q));
                    pw.flush();
                    if (StringUtils.isNotBlank(resp)) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("code", FreedomConstant.FREEDOM_RESP_CODE);
                        map.put("resp", resp);
                        pw.println(JSONObject.toJSONString(map));
                        pw.flush();
                        String clientResp = br.readLine();
                        Map clientMap = JSON.parseObject(clientResp, Map.class);
                        if (clientMap != null) {
                            if (FreedomConstant.FREEDOM_CLIENT_RESP_CODE.equalsIgnoreCase(String.valueOf(clientMap.get("code")))) {
                                String clientRespResult = String.valueOf(clientMap.get("clientResp"));
                                if (StringUtils.isNotBlank(clientRespResult)) {
                                    return clientRespResult;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    log.error("readCard error", e);
                }
                return "";
            }
        };
        try {
            byte[] reqID = new byte[35];
            int num = FreedomReadCardService.LgetLib.INSTANCE.JLRCs("1440C00", fid, tidid, reqID, Integer.parseInt(Integer.toHexString(len), 16), 2, mycall, 3);
            //num为999代表读卡成功，其它读卡失败
            if (num == FreedomConstant.READCARD_SUCCESS_CODE) {
                log.info("FreedomReadCardService fid is {},num is {},readCard success", fid, num);
            } else {
                log.info("FreedomReadCardService fid is {},num is {},readCard fail", fid, num);
            }
            StringBuffer reqIdSb = new StringBuffer();
            for (int i = 0; i < reqID.length; i++) {
                reqIdSb.append((char) reqID[i]);
            }
            if (StringUtils.isNotBlank(reqIdSb.toString())) {
                log.info("FreedomReadCardService fid is {},reqId is {}", fid, reqIdSb.toString());
            }
            EidlinkService.initBasicInfo("testnidocr.eidlink.com", 8080, "1440C00", "TESTID20200412182417", "7D470E40C2E28DA025BA86E17A85B270");
            PublicParam publicParam = new PublicParam();
            IdCardCheckParam idCardCheckParam = new IdCardCheckParam(publicParam, reqIdSb.toString());
            CommonResult result = EidlinkService.idCardCheck(idCardCheckParam);
            log.info("idCardCheck param is {},result is {}",
                    JSONObject.toJSONString(idCardCheckParam), JSONObject.toJSONString(result));
            if (FreedomConstant.CARD_CHECK_CODE.equals(result.getResult())) {
                String ciphertext = result.getCiphertext(); //身份密文信息
                String picture = result.getPicture();
                Map<String, Object> map = new HashMap<>();
                map.put("ciphertext", ciphertext);
                map.put("picture", picture);
                map.put("code", FreedomConstant.FREEDOM_SERVER_RESP_CODE);
                pw.println(JSONObject.toJSONString(map));
                pw.flush();
            }
        } catch (Exception e) {
            log.error("FreedomReadCardService readCard error", e);
        } finally {
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                log.error("FreedomReadCardService ");
            }
        }
    }

}
