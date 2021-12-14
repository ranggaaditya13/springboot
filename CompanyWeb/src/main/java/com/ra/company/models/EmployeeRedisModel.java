package com.ra.company.models;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "employee")
public class EmployeeRedisModel{
	@Id
	@Indexed
	private int id;
	private String nama;
	private String jenis_kelamin;
	private String telephone;

}
