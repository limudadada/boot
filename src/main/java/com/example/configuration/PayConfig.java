package com.example.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "pay")
@Data
@Configuration
public class PayConfig {

    private String url;

    private String signKeyFile;

    private String signKeyPasswd;

    private String verifyCerFile;
}
