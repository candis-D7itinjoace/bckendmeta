package com.example.metaData.dto.response;

import lombok.Data;

@Data
public class ChatGPTCompletionResponse {


    private String result;

    public ChatGPTCompletionResponse(String result) {
        this.result = result;
    }






}
