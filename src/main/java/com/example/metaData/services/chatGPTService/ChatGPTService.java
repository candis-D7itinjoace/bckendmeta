package com.example.metaData.services.chatGPTService;

import com.example.metaData.dto.request.ChatGPTCompletionRequest;
import com.example.metaData.dto.response.ChatGPTCompletionResponse;

public interface ChatGPTService {



    ChatGPTCompletionResponse prompt(ChatGPTCompletionRequest request) throws Exception;



}
