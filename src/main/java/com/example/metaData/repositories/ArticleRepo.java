package com.example.metaData.repositories;

import com.example.metaData.models.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends MongoRepository<Article, String> {
}
