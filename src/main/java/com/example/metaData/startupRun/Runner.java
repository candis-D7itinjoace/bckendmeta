package com.example.metaData.startupRun;

import com.example.metaData.models.Article;
import com.example.metaData.models.Regulation;
import com.example.metaData.repositories.ArticleRepo;
import com.example.metaData.repositories.RegulationRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {


    @Autowired
    private RegulationRepo regulationRepo;


    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public void run(String... args) throws Exception {


//        File jsonFile = new ClassPathResource("static/rgpd1.json").getFile();
//
//        // Read JSON file and parse records
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<ArticleTransferObject> records = objectMapper.readValue(jsonFile, objectMapper.getTypeFactory().constructCollectionType(List.class, ArticleTransferObject.class));
//
//        // Save records to database
//        Regulation regulation = new Regulation();
//        regulation.setName("pipeda");
//        regulation.setCountry("canada");
//
////        System.out.println(regulation.getName());
//        List<Article> articles = new ArrayList<>();
//        records.forEach(record -> {
//            Article article = new Article();
//            article.setTitle(record.getTitle());
//            article.setSummary(record.getSummary());
//            article.setNumber(record.getNumber());
//            articles.add(articleRepo.save(article));
//        });

//        regulationRepo.findAll().forEach(item -> {
//            System.out.println("this is the regulation name");
//            System.out.println(item.getName());
//        });

//        articleRepo.findAll().forEach(
//                item -> {
//                    System.out.println("this is the number");
//                    System.out.println(item.getNumber());
//                }
//        );

//        regulation.setArticles(articles);
//        regulationRepo.save(regulation);
//
////        List<Article> finalList = new ArrayList<>(regulation.getArticles());
////        finalList.addAll(articles);
////        regulation.setArticles(finalList);




    }

}
