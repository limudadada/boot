package com.example.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Http工具类
 *
 * @author ysm
 * 2017年4月10日
 */
public class HttpClientUtil extends HttpClientBaseConfig {

    /**
     * httpclient
     */
    private static CloseableHttpClient httpClient = null;

    static {
        try {
            initHttpClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过POST方式提交数据请求指定的服务url TODO 2018年4月25日
     *
     * @param url
     * @param params
     * @return
     * @author Teacher Tian
     */
    public static HttpRequestResult doPostData(String url, Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return null;
        }
        HttpPost httppost = null;
        CloseableHttpResponse response = null;
        try {
            httppost = new HttpPost(url);
            setPostParams(httppost, params);
            logger.info("HttpRequestResult param is {}",JSONObject.toJSONString(httppost.getEntity()));
            response = httpClient.execute(httppost, HttpClientContext.create());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                httppost.abort();
                return new HttpRequestResult(HttpRequestStatusCodeEnum.valueOf(statusCode), false,
                        JSONObject.toJSONString(response));
            }
            String result = "";
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            }
            return new HttpRequestResult(HttpRequestStatusCodeEnum.valueOf(statusCode), true, result);
        } catch (SocketTimeoutException e) {
            logger.error("socket connect timeout by send url:{},params:{},ex:{}", url, JSONObject.toJSONString(params),
                    e);
            httppost.abort();
            return new HttpRequestResult(HttpRequestStatusCodeEnum.CONNECT_TIMEOUT, false, e.getMessage());
        } catch (ConnectTimeoutException | ConnectException e) {
            httppost.abort();
            logger.error("connect timeout by send url:{},params:{},ex:{}", url, JSONObject.toJSONString(params), e);
            return new HttpRequestResult(HttpRequestStatusCodeEnum.CONNECT_TIMEOUT, false, e.getMessage());
        }  catch (IOException e) {
            httppost.abort();
            logger.error("io exception send url:{},params:{},ex:{}", url, JSONObject.toJSONString(params), e);
            return new HttpRequestResult(HttpRequestStatusCodeEnum.BAD_REQUEST, false, e.getMessage());
        } catch (Exception e) {
            httppost.abort();
            logger.error("server exception send url:{},params:{},ex:{}", url, JSONObject.toJSONString(params), e);
            return new HttpRequestResult(HttpRequestStatusCodeEnum.INTERNAL_SERVER_ERROR, false, e.getMessage());
        } finally {

            try {
                if (response != null) {
                    EntityUtils.consume(response.getEntity());
                }

            } catch (IOException e) {
                logger.error("close response failed!url:{},params:{},ex:{}", url, JSONObject.toJSONString(params), e);
                httppost.abort();
            }
        }

    }

    public static CloseableHttpResponse doPostMap(String url, Map<String, String> param) throws Exception {
        // 创建Httpclient对象
        CloseableHttpResponse response = null;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            UrlEncodedFormEntity entity = buildCloseableParams(param);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            //logger.info("HttpClientUtils doPostMap response:{}", JSONObject.toJSONString(response));
        } catch (Exception e) {
            logger.error("HttpClient doPostMap is error", e);
        }
        return response;
    }

    /**
     * 初始化HttpClient
     *
     * @return
     * @throws Exception
     */
    private static CloseableHttpClient initHttpClient() throws Exception {
        return httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setKeepAliveStrategy(new ConnectionKeepAliveStrategy() {
                    @Override
                    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                        HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator());
                        while (it.hasNext()) {
                            HeaderElement he = it.nextElement();
                            String param = he.getName();
                            String value = he.getValue();
                            if (value != null && param.equalsIgnoreCase("timeout")) {
                                try {
                                    return Long.parseLong(value) * 1000;
                                } catch (NumberFormatException ignore) {
                                }
                            }
                        }
                        return 30 * 1000;

                    }
                })
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
    }

    /**
     * 构建CloseableHttp请求参数
     *
     * @param param
     * @return
     * @throws UnsupportedEncodingException
     */
    private static UrlEncodedFormEntity buildCloseableParams(Map<String, String> param) throws UnsupportedEncodingException {
        // 创建参数列表
        if (param != null) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : param.keySet()) {
                paramList.add(new BasicNameValuePair(key, param.get(key)));
            }
            // 模拟表单
            return new UrlEncodedFormEntity(paramList, PayConstants.PROJECT_DEFAULT_ENCODING);
        }
        return null;
    }

    /**
     * 设置post参数entity对象,注意这里过滤掉了map中value==null或者""的key; TODO 2018年7月27日
     *
     * @param httpost
     * @param params
     * @throws UnsupportedEncodingException
     * @author Teacher Tian
     */
    private static void setPostParams(HttpPost httpost, Map<String, String> params) throws UnsupportedEncodingException {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            logger.info("-----------------http key is------------ {}",key);
            if (StringUtils.isNotBlank(params.get(key))) {
                logger.info("--------------http value is----------------{}",params.get(key));
                nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
        }

            logger.info("HttpClientComponent postData:{}", JSONObject.toJSONString(nvps));

        httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
    }

}