package com.rangga.perusahaan.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "karyawan")
public class KaryawanModel {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nis")
	private String nis;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="tempatLahir")
	private String tempatLahir;
	
	@Column(name="tanggalLahir")
	private String tanggalLahir;
	
	@Column(name="alamat")
	private String alamat;
	
	@Column(name="noHp")
	private String noHp;
	
	@Column(name="createdBy")
	private int createBy;
	
	@Column(name="createdOn")
	private Timestamp createOn;
	
	@Column(name="modifiedBy",nullable = true)
	private int modifiedBy;
	
	@Column(name="modifiedOn",nullable = true )
	private Timestamp modifiedOn;
	
	@Column(name="deletedBy",nullable = true)
	private int deletedBy;
	
	@Column(name="deletedOn",nullable = true)
	private Timestamp deletedOn;
	
	@Column(name="isDelete",nullable = true)
	private Boolean isDelete;
		

}
