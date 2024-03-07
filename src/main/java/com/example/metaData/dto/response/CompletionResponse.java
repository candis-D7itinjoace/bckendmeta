package com.example.metaData.dto.response;

import com.example.metaData.startupRun.ArticleTransferObject;
import lombok.Data;

import java.util.List;

@Data
public class CompletionResponse {

    List<ArticleTransferObject> articles;

}
