package com.example.restservice.controllers.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.models.doctor.Doctor;
import com.example.restservice.repository.DoctorRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAlldoctors(@RequestParam(required = false) String name) {
        try {
            List<Doctor> doctors = new ArrayList<Doctor>();

            if (name == null)
                doctorRepository.findAll().forEach(doctors::add);
            else
                doctorRepository.findByNameContaining(name).forEach(doctors::add);

            if (doctors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctors/{doctor_id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctor_id") long doctor_id) {
        Optional<Doctor> DoctorData = doctorRepository.findById(doctor_id);

        if (DoctorData.isPresent()) {
            return new ResponseEntity<>(DoctorData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor Doctor) {
        try {
            Doctor _Doctor = doctorRepository
                    .save(new Doctor(Doctor.getName(), Doctor.getSpeciality(), Doctor.getAddress(), Doctor.getHosname(), Doctor.getAbout()));
            return new ResponseEntity<>(_Doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/doctors/{doctor_id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("doctor_id") long doctor_id, @RequestBody Doctor Doctor) {
        Optional<Doctor> DoctorData = doctorRepository.findById(doctor_id);

        if (DoctorData.isPresent()) {
            Doctor _Doctor = DoctorData.get();
            _Doctor.setName(Doctor.getName());
            _Doctor.setSpeciality(Doctor.getSpeciality());
            _Doctor.setAddress(Doctor.getAddress());
            _Doctor.setHosname(Doctor.getHosname());
            _Doctor.setAbout(Doctor.getAbout());
            return new ResponseEntity<>(doctorRepository.save(_Doctor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/doctors/{doctor_id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("doctor_id") long doctor_id) {
        try {
            doctorRepository.deleteById(doctor_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/doctors")
    public ResponseEntity<HttpStatus> deleteAlldoctors() {
        try {
            doctorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @GetMapping("/doctors/address")
//    public ResponseEntity<List<Doctor>> findByaddress() {
//        try {
//            List<Doctor> doctors = DoctorRepository.findByAddress(address);
//
//            if (doctors.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(doctors, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}