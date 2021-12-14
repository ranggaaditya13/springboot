package com.ra.company.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "employee")
public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nama")
	private String nama;
	
	@Column(name="jenis_kelamin")
	private String jenis_kelamin;
	
	@Column(name="telephone")
	private String telephone;

}
