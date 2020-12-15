package com.example.restservice.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.restservice.models.patient.Patient;

import com.example.restservice.models.report.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {




}
