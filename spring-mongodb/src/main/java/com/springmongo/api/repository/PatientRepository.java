package com.springmongo.api.repository;

import com.springmongo.api.model.PatientModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PatientRepository extends MongoRepository<PatientModel,Integer> {
    default Optional<PatientModel> findByPatientName(String patient_name) {
        return null;
    }
}
