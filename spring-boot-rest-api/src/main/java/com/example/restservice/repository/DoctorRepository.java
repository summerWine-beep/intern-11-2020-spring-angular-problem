package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.doctor.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//    List<Doctor> findByAddress(String address);
    List<Doctor> findByNameContaining(String name);

    Optional<Doctor> findById(long doctor_id);
}