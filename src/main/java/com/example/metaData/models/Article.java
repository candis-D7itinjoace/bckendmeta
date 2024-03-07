package com.example.metaData.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {


    @Id
    private String _id;
    private String number;
    private String title;
    private String summary;

    private Regulation regulation;

}
