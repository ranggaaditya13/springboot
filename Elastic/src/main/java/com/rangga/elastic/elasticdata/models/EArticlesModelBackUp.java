package com.rangga.elastic.elasticdata.models;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Document(indexName = "article_back")
@Data
public class EArticlesModelBackUp {
	
	@Id
	private String id;
	
	private String title;
	
	private String category;

}
