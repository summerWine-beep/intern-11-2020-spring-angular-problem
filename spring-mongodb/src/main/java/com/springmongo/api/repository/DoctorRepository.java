package com.springmongo.api.repository;

import com.springmongo.api.model.DoctorModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface DoctorRepository extends MongoRepository<DoctorModel,Integer> {
    default Optional<DoctorModel> findByDoctorName(String doctor_name) {
        return null;
    }


}
