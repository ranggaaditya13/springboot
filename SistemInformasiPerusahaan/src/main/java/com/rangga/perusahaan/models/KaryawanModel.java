package com.rangga.perusahaan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "karyawan")
public class KaryawanModel {
	
	@Id
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
		

}
