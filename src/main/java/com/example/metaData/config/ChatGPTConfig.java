package com.example.metaData.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ChatGPTConfig {

    @Value("${chatgpt.apiKey}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    private void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}