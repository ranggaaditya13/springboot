package com.rangga.reactive.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeModel {
	
	@Id
	private String id;
	private String name;
	private long salary;

}
