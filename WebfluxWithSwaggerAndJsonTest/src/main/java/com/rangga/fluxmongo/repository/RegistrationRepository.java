package com.rangga.fluxmongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.rangga.fluxmongo.models.StudentModels;

@Repository
public interface RegistrationRepository extends ReactiveMongoRepository<StudentModels, String>{

}
