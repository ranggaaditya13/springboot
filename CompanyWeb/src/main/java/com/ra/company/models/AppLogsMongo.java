package com.ra.company.models;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "app_logs")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AppLogsMongo {

	@Id
	private String id;
	private Date date;
	private String level;
	private String message;
	
}
