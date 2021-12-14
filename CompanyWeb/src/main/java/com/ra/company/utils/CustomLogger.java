package com.ra.company.utils;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.ra.company.models.AppLogsMongo;

@Component
public class CustomLogger {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public String info(String message) {
		AppLogsMongo logs = new AppLogsMongo();
		logs.setLevel("INFO");
		logs.setMessage(message);
		logs.setDate(new Date());
		mongoTemplate.insert(logs);
		
		return message;
	}

}
