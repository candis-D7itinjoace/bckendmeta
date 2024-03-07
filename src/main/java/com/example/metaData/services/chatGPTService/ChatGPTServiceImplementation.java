package com.example.metaData.services.chatGPTService;

import com.example.metaData.config.ChatGPTConfig;
import com.example.metaData.dto.request.ChatGPTCompletionRequest;
import com.example.metaData.dto.response.ChatGPTCompletionResponse;
import com.example.metaData.dto.response.CompletionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ChatGPTServiceImplementation implements ChatGPTService{



    private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=";


    @Autowired
    private ChatGPTConfig chatConfig;

    @Autowired
    private WebClient.Builder builder;


    @Override
    public ChatGPTCompletionResponse prompt(ChatGPTCompletionRequest request) throws Exception {



        Map<String, String> headers = new HashMap<>();

        headers.put("Content-Type", "application/json");

        MultiValueMap<String, String> h = new LinkedMultiValueMap<>();
        h.forEach((key, value) -> h.add(key, value.toString()));



        String response = builder.build().post()
                .uri(API_URL+"AIzaSyCfyvX67r04clMG6-Hx4loxHX7B-hZgPgI")
                .headers(httpHeaders -> httpHeaders.addAll(h))
                .body(BodyInserters.fromValue("{\"contents\":[{\"parts\":[{\"text\":\"" + request.getPrompt() + "\"}]}]}"))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(response);

        int startIndex = response.indexOf("\"text\"") + "\"text\":\"".length();
        int endIndex = response.indexOf("\"\n          }\n        ],\n        \"role\": ", startIndex);

        System.out.println(response.length());

        String textValue = response.substring(startIndex + 2, endIndex);

        System.out.println(textValue);


        return new ChatGPTCompletionResponse(textValue.replace("\\n", " "));
    }
}
