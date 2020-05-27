package com.example.socket;

import com.alibaba.fastjson.JSONObject;
import com.example.model.EduScoreDTO;
import com.example.model.EduScoreItemDTO;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClient {

    public static void main(String[] args){
        // 创建httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post请求方式实例
        HttpPost httpPost = new HttpPost("http://localhost:8094/v1/score/eduScore/update");
        // 设置请求头 发送的是json数据格式
//        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
//        httpPost.setHeader("Connection", "Close");
//        Test test = new Test();
//        test.setAge(30);
//        test.setName("name");
//        List<Map> list = new ArrayList<>();
//        Map map = new HashMap<>();
//        map.put("ppp","123");
//        list.add(map);
//        test.setList(list);
        EduScoreDTO eduScoreDTO = new EduScoreDTO();
        eduScoreDTO.setId(1260385542726643713l);
        eduScoreDTO.setExam_id(1259728092948230145l);
        EduScoreItemDTO eduScoreItemDTO = new EduScoreItemDTO();
        eduScoreItemDTO.setId(1260385542948941826l);
        eduScoreItemDTO.setScore(66.6f);
        List<EduScoreItemDTO> list = new ArrayList<>();
        list.add(eduScoreItemDTO);
        eduScoreDTO.setScore_items(list);
        System.out.println(JSONObject.toJSONString(eduScoreDTO));

        EduScoreDTO eduScoreDTOw = new EduScoreDTO();
        eduScoreDTOw.setId(1260385542823112705l);
        eduScoreDTOw.setExam_id(1259728092948230145l);
        EduScoreItemDTO eduScoreItemDTOw = new EduScoreItemDTO();
        eduScoreItemDTOw.setId(1260385543179628546l);
        eduScoreItemDTOw.setScore(56.6f);
        List<EduScoreItemDTO> listw = new ArrayList<>();
        listw.add(eduScoreItemDTOw);
        eduScoreDTOw.setScore_items(listw);
        System.out.println(JSONObject.toJSONString(eduScoreDTOw));


        List<EduScoreDTO> dtoList = new ArrayList<>();
        dtoList.add(eduScoreDTO);
        dtoList.add(eduScoreDTOw);


        // 设置参数---设置消息实体 也就是携带的数据
        StringEntity entity = new StringEntity(JSONObject.toJSONString(dtoList), Charset.forName("UTF-8"));
        // 设置编码格式
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        // 把请求消息实体塞进去
        httpPost.setEntity(entity);
        // 执行http的post请求
        CloseableHttpResponse httpResponse;
        String result = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
