package com.example.metaData.controller;

import com.example.metaData.dto.request.ChatGPTCompletionRequest;
import com.example.metaData.dto.response.ChatGPTCompletionResponse;
import com.example.metaData.dto.response.CompletionResponse;
import com.example.metaData.models.Article;
import com.example.metaData.models.Label;
import com.example.metaData.services.LabelService;
import com.example.metaData.services.chatGPTService.ChatGPTService;
import com.example.metaData.services.regulationService.RegulationService;
import com.example.metaData.startupRun.ArticleTransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/label")

public class LabelController {
    @Autowired
    private LabelService labelService;


    @Autowired
    private RegulationService regulationService;


    @Autowired
    private ChatGPTService gptService;

    @PostMapping
    public ResponseEntity<Label> createLabel(@RequestBody Label label)
    {
         labelService.SaveOrUpdate(label);
        return new ResponseEntity<>(label, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Label>>getAll()
    {
        List<Label>list=labelService.listAll();
        return new ResponseEntity<>(list,HttpStatus.OK);

    }
    @PutMapping("/{_id}")
    public ResponseEntity<Label>updateLabel(@RequestBody Label label,@PathVariable String _id)
    {
        Label updateLabel=labelService.updateLabel(label,_id);
        return new ResponseEntity<>(updateLabel,HttpStatus.OK);
    }
    @DeleteMapping("/{_id}")
    public ResponseEntity<String>deleteLabel(@PathVariable String _id)
    {
       labelService.deleteLabel(_id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }



    @PostMapping("/getPrompt")
    public ResponseEntity<?> getPrompt (@RequestBody ChatGPTCompletionRequest request) throws Exception {
        try {
            return ResponseEntity.ok(gptService.prompt(request));
    }catch (Exception e) {
        throw new Exception(e);
        }
    }


    @PostMapping("/addpr")
    public ResponseEntity<?> setPrompt(@RequestBody ChatGPTCompletionRequest request) {
        List<Article> articles = regulationService.getArticles(request);
        CompletionResponse response = new CompletionResponse();
        response.setArticles(articles.stream().map(article -> new ArticleTransferObject(article.getNumber(), article.getTitle(), article.getSummary())).toList());
        return ResponseEntity.ok(response);
    }







//    @PostMapping("/affecter")
//    public ResponseEntity<?>affecter()
//    {
//
//    }
}
