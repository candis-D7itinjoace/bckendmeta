package com.example.metaData.services.regulationService;

import com.example.metaData.dto.request.ChatGPTCompletionRequest;
import com.example.metaData.models.Article;

import java.util.List;

public interface RegulationService {

    List<Article> getArticles(ChatGPTCompletionRequest request);
}
