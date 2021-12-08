package com.mega.redis.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class KaryawanModel implements Serializable {
	
	private static final long serialVersionUID = -7817224776021728682L;
	
	private int id;
	private String nama;
	private String gaji;
	
	

}
