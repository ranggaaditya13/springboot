package com.ra.company.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ra.company.models.AppLogsMongo;

public interface AppLogsMongoRepository extends MongoRepository<AppLogsMongo, String> {

}
