package com.example.metaData.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.metaData.models.Regulation;
@Repository
public interface RegulationRepo extends MongoRepository<Regulation,String> {
    Regulation findByName(String rgpd);
}
