package com.example.metaData.startupRun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleTransferObject implements Serializable {

    private String number;
    private String title;
    private String summary;

}