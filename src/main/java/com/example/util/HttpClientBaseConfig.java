package com.example.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @program HttpClientBaseConfig
 * @description: httpclient基础配置
 * @author: cxn
 * @create: 2019/09/04 19:28
 */
public class HttpClientBaseConfig {


    protected static final Logger logger = LoggerFactory.getLogger(HttpClientBaseConfig.class);
    private static final String HTTP = "http";
    private static final String HTTPS = "https";


    protected static final String ACCEPT = "Accept";
    protected static final String CONTENT_TYPE = "Content-Type";
    protected static final String APPLICATION_JSON = "application/json";

    /**
     * 连接超时时间8s
     */
    private static final int CONNECT_TIMEOUT = 8000;
    /**
     * 读取数据超时时间15s
     */
    private static final int SOCKET_TIMEOUT = 15000;
    /**
     * 从连接池获取连接超时时间1s
     */
    private static final int CONNECTION_REQUEST_TIMEOUT = 1000;
    /**
     * 最大连接数
     */
    private static final int MAX_TOTAL = 512;
    /**
     * 到同一个地址最大连接数
     */
    private static final int MAX_PER_ROUTE = 150;

    protected static SSLConnectionSocketFactory sslsf = null;

    public static PoolingHttpClientConnectionManager cm = null;

    private static SSLContextBuilder builder = null;

    protected static RequestConfig defaultRequestConfig = null;

    static {
        try {
            initHttpClientConfig();
        } catch (Exception e) {
           logger.error("HttpClientBaseConfig static error", e);
        }
    }

    /**
     * 初始化HttpClient公共配置
     */
    private static void initHttpClientConfig() throws Exception {
        builder = new SSLContextBuilder();
        // 全部信任 不做身份鉴定
        builder.loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        });

        sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1","TLSv1.1","TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register(HTTP, new PlainConnectionSocketFactory())
                .register(HTTPS, sslsf)
                .build();

        cm = new PoolingHttpClientConnectionManager(registry);
        cm.setMaxTotal(MAX_TOTAL);
        cm.setDefaultMaxPerRoute(MAX_PER_ROUTE);

        defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .build();
    }
}
