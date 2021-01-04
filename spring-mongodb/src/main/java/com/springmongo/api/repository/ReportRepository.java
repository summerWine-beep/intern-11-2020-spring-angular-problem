package com.springmongo.api.repository;

import com.springmongo.api.model.DietModel;
import com.springmongo.api.model.MedicineModel;
import com.springmongo.api.model.ReportsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends MongoRepository<ReportsModel, String> {
    Iterable<ReportsModel> findAllById(int patient_id);


}
