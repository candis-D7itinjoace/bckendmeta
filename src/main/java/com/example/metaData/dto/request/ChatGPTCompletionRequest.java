package com.example.metaData.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ChatGPTCompletionRequest {

    private String prompt;
    private String regulation;

}
