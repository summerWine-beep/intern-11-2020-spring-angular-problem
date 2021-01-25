package com.example.restservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.patient.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {

    List<Patient> findByNameContaining(String name);
    List<Patient> findByNameAndDobContaining(String name, String dob);
}