package com.springmongo.api.repository;

import com.springmongo.api.model.PatientModel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PatientRepository extends MongoRepository<PatientModel,Integer> {
}
