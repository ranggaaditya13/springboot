package com.rangga.reactive.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEvent {
	
	private EmployeeModel employee;
	private Date date;

}
