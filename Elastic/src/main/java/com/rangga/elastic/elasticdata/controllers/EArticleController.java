package com.rangga.elastic.elasticdata.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.elastic.elasticdata.services.EArticleService;
import com.rangga.elastic.elasticdata.utils.HttpComponentDelete;
import com.rangga.elastic.elasticdata.utils.HttpComponentPost;
import com.rangga.elastic.mysql.services.ArticleService;

@Component
@RestController
public class EArticleController {
	
	private String indexActive = "article_1";
	private String indexTemp = "article_back";
	private Logger log = LogManager.getLogger(EArticleController.class);
	
	@Value("${spring.elasticsearch.uris}")
	private String uri;
	
	@Autowired
	private ArticleService ESDataService;
	
	@Autowired
	private EArticleService ESService;
	
	@Scheduled(initialDelay = 1000*1, fixedDelay = Long.MAX_VALUE)
	public void setAliasFirst() {
		
		String requestTukarAlias = "{\"actions\":[{\"add\":{\"index\":\"article_1\",\"alias\":\"article\"}}]}";

		HttpComponentPost httpPost = new HttpComponentPost();
		httpPost.setUrl(uri);
		httpPost.sendToHttpPost(requestTukarAlias, "_aliases");
		
		System.out.println("requestAwal: " + requestTukarAlias);
	}
	
	@Scheduled(cron = "${cron.exp}")
	@PostMapping(value = "/copydata")
	public String copyData() {
		
		long start = System.currentTimeMillis();
		
		try {
			HttpComponentDelete hhtpDelete = new HttpComponentDelete();
			hhtpDelete.setUrl(uri);
			hhtpDelete.sendToHttpDelete(indexTemp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			
			ESService.saveToES(indexTemp);
			
			String requestTukarAlias = "{\"actions\":[{\"remove\":{\"index\":\"" 
										+ indexActive 
										+ "\",\"alias\":\"article\"}},{\"add\":{\"index\":\"" 
										+ indexTemp 
										+ "\",\"alias\":\"article\"}}]}";

			HttpComponentPost httpPost = new HttpComponentPost();
			httpPost.setUrl(uri);
			httpPost.sendToHttpPost(requestTukarAlias, "_aliases");
			
			String temp = indexActive;
			indexActive = indexTemp;
			indexTemp = temp;
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Elapsed Time in milliseconds: " + (end - start));
		System.out.println("indexActive: " + indexActive);
		System.out.println("indexTemp: " + indexTemp);
		
		return "OK";
	}

}
