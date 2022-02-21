package com.rangga.reactive.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rangga.reactive.models.EmployeeModel;

public interface EmployeeRepository extends ReactiveMongoRepository<EmployeeModel, String>{

}
