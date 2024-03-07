package com.example.metaData.repositories;

import com.example.metaData.models.Documentation;
import com.example.metaData.models.Label;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // fc pré defini

public interface LabelRepository extends MongoRepository<Label,String> {


    List<Label> findByDocumentationIds(String documentationId);
}
