package com.rangga.fluxmongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@AllArgsConstructor
@Document
@ToString
@NoArgsConstructor
public class StudentModels {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;

}
