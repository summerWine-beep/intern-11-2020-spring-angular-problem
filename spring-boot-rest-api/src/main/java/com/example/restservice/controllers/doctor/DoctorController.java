package com.example.restservice.controllers.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import javax.print.Doc;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        try {
            Doctor _doctor = doctorRepository.save(new Doctor(
                    doctor.getDoctorName(),
                    doctor.getSpeciality(),
                    doctor.getDoctorAddress(),
                    doctor.getHospitalName(),
                    doctor.getAbout(),
                    doctor.getProfilePicture()
            ));
            return new ResponseEntity<>(_doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam(required = false) String doctorName) {
        try {
            List<Doctor> doctors = new ArrayList<Doctor>();

            if (doctorName == null) {
                doctorRepository.findAll().forEach(doctors::add);
            }else {
                doctorRepository.findByDoctorNameContaining(doctorName).forEach(doctors::add);
            }

            if (doctors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") String id) {
        Optional<Doctor> doctorData = doctorRepository.findById(id);

        if (doctorData.isPresent()) {
            return new ResponseEntity<>(doctorData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/doctors/name/{doctorName}")
    public ResponseEntity<List<Doctor>>  getDoctorByDoctorName(@PathVariable("doctorName") String doctorName) {
        List<Doctor> doctors = new ArrayList<Doctor>();
        List <Doctor> doctorData = doctorRepository.findByDoctorNameContaining(doctorName);

        if (!doctorData.isEmpty()) {
            doctorRepository.findByDoctorNameContaining(doctorName).forEach(doctors::add);
            return new ResponseEntity<>(doctors, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") String id, @RequestBody Doctor doctor) {
        Optional<Doctor> doctorData = doctorRepository.findById(id);

        if (doctorData.isPresent()) {
            Doctor _doctor = doctorData.get();
            _doctor.setDoctorName(doctor.getDoctorName());
            _doctor.setSpeciality(doctor.getSpeciality());
            _doctor.setDoctorAddress(doctor.getDoctorAddress());
            _doctor.setHospitalName(doctor.getHospitalName());
            _doctor.setAbout(doctor.getAbout());
            _doctor.setProfilePicture(doctor.getProfilePicture());
            return new ResponseEntity<>(doctorRepository.save(_doctor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("id") String id) {
        try {
            doctorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/doctors")
    public ResponseEntity<HttpStatus> deleteAllDoctors() {
        try {
            doctorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}