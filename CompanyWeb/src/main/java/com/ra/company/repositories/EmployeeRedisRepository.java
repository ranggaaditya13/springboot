package com.ra.company.repositories;

import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import com.ra.company.models.EmployeeRedisModel;


public interface EmployeeRedisRepository extends CrudRepository<EmployeeRedisModel, Integer>{

}
