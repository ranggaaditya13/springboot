package com.rangga.upload.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "karyawan")
@Data
public class KaryawanModel {
	
	@Id
	@Column(name = "nama")
	private String nama ;
	
	@Column(name = "posisi")
	private String posisi;
	
	@Column(name ="jenis_kelamin")
	private String jenis_kelamin;
	
	@Column(name="foto")
	private String foto;
	

}
