package com.example.metaData.services.regulationService;

import com.example.metaData.dto.request.ChatGPTCompletionRequest;
import com.example.metaData.models.Article;
import com.example.metaData.repositories.ArticleRepo;
import com.example.metaData.repositories.RegulationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegulationServiceImpl implements RegulationService{

    @Autowired
    private RegulationRepo regulationRepo;

    private List<Article> filterStrings(String inputString, List<Article> stringList) {
        // Split the input string into words
        List<String> words = Arrays.asList(inputString.split(" "));

        // Filter the list of strings based on whether any word from the input string exists in each string
        return stringList.stream()
                .filter(str -> words.stream().anyMatch(word -> str.getTitle().contains(word)) || words.stream().anyMatch(word -> str.getNumber().contains(word)) || words.stream().anyMatch(word -> str.getSummary().contains(word)))
                .collect(Collectors.toList());
    }



    public List<Article> getArticles(ChatGPTCompletionRequest request) {
        return filterStrings(request.getPrompt(), regulationRepo.findByName(request.getRegulation()).getArticles());
    }




}
