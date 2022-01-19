package com.rangga.elastic.elasticdata.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rangga.elastic.elasticdata.models.EArticlesModel;
import com.rangga.elastic.elasticdata.repositories.EArtcilesBackRepository;
import com.rangga.elastic.elasticdata.repositories.EArtcilesRepository;
import com.rangga.elastic.elasticdata.utils.HttpComponentPost;
import com.rangga.elastic.mysql.repositories.ArticleRepository;

@Service
public class EArticleService {
	
	@Autowired
	private EArtcilesBackRepository ESRepo2;
	
	@Autowired
	private EArtcilesRepository ESRepo;
	
	@Autowired
	private ArticleRepository ESDataRepo;
	
	@Value("${spring.elasticsearch.uris}")
	private String uri;
	
	@Value("${bulk.limit}")
	private String bulkLimit;

	public EArticlesModel save(EArticlesModel ESModel) {
		// TODO Auto-generated method stub
		return ESRepo.save(ESModel);
	}

	public void delete(EArticlesModel ESModel) {
		// TODO Auto-generated method stub
		ESRepo.delete(ESModel);
	}

	public Optional<EArticlesModel> findById(String id) {
		// TODO Auto-generated method stub
		return ESRepo.findById(id);
	}

	public Iterable<EArticlesModel> findAll() {
		// TODO Auto-generated method stub
		return ESRepo.findAll();
	}
	
	public void saveToES(String index) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> mysqlData = ESDataRepo.listAll();
		
		int totalData = mysqlData.size();
		int indexNow = 0;
		
		int bulkLmt = Integer.parseInt(bulkLimit);
		
		while (totalData > 0) {
			
			String request = "";
			
			if (totalData < bulkLmt) {
				for (int i = indexNow; i < mysqlData.size(); i++) {
					request += "{\"create\": {\"_id\": \"" 
							+ mysqlData.get(i).get("article_id").toString() 
							+ "\", \"_index\": \"" + index + "\"}}" 
							+ System.lineSeparator();
					request += "{\"id\": \"" 
							+ mysqlData.get(i).get("article_id").toString()
							+ "\", \"name\": \"" 
							+ mysqlData.get(i).get("title").toString() 
							+ "\", \"create_date\": \"" 
							+ mysqlData.get(i).get("category").toString()
							+ "\"}" 
							+ System.lineSeparator();
				}
			} else {
				for (int i = indexNow; i < indexNow + bulkLmt; i++) {
					request += "{\"create\": {\"_id\": \"" 
							+ mysqlData.get(i).get("article_id").toString() 
							+ "\", \"_index\": \"" + index + "\"}}" 
							+ System.lineSeparator();
					request += "{\"id\": \"" 
							+ mysqlData.get(i).get("article_id").toString()
							+ "\", \"name\": \"" 
							+ mysqlData.get(i).get("title").toString() 
							+ "\", \"create_date\": \"" 
							+ mysqlData.get(i).get("category").toString()
							+ "\"}" 
							+ System.lineSeparator();
				}
			}
			
		
			HttpComponentPost httpPost = new HttpComponentPost();
			httpPost.setUrl(uri);
			httpPost.sendToHttpPost(request, "_bulk");
			
			indexNow += bulkLmt;
			totalData -= bulkLmt;
		}
		

	}

}
