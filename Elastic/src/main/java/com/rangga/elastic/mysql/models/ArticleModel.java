package com.rangga.elastic.mysql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "articles")
@Data
public class ArticleModel {
	
	@Id
	@Column(name = "article_id")
	private int articleId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;

}
