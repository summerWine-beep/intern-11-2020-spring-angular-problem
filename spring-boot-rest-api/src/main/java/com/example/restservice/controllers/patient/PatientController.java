package com.example.restservice.controllers.patient;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.restservice.models.doctor.Doctor;
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

import com.example.restservice.models.patient.Patient;
import com.example.restservice.repository.PatientRepository;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/patients")
    public ResponseEntity<Patient> createDoctor(@RequestBody Patient patient) {
        try {
            Patient _patient = patientRepository.save(new Patient(
                    patient.getPatientName(),
                    patient.getEntryDatetime(),
                    patient.getDob(),
                    patient.getAge(),
                    patient.getGender(),
                    patient.getOccupation(),
                    patient.getHealthInsuranceNo(),
                    patient.getHealthCareProvider(),
                    patient.getPatientAddress(),
                    patient.getContactNo(),
                    patient.getDoctorId()
            ));
            return new ResponseEntity<>(_patient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients(@RequestParam(required = false) String patientName) {
        try {
            List<Patient> patients = new ArrayList<Patient>();

            if (patientName == null) {
                patientRepository.findAll().forEach(patients::add);
            }else {
                patientRepository.findByPatientNameContaining(patientName).forEach(patients::add);
            }

            if (patients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") String id) {
        Optional<Patient> patientData = patientRepository.findById(id);

        if (patientData.isPresent()) {
            return new ResponseEntity<>(patientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/patients/name/{name}")
    public ResponseEntity<List<Patient>>  getByPatientname(@PathVariable("name") String patientName) {
        List<Patient> patients = new ArrayList<Patient>();
        System.out.println(patientName);
        List <Patient> patientData = patientRepository.findByPatientNameContaining(patientName);

        if (!patientData.isEmpty()) {
            patientRepository.findByPatientNameContaining(patientName).forEach(patients::add);
            return new ResponseEntity<>(patients, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") String id, @RequestBody Patient patient) {
        Optional<Patient> patientData = patientRepository.findById(id);
        if (patientData.isPresent()) {
            Patient _patient = patientData.get();
            _patient.setPatientName(patient.getPatientName());
            _patient.setDob(patient.getDob());
            _patient.setAge(patient.getAge());
            _patient.setGender(patient.getGender());
            _patient.setOccupation(patient.getOccupation());
            _patient.setHealthInsuranceNo(patient.getHealthInsuranceNo());
            _patient.setHealthCareProvider(patient.getHealthCareProvider());
            _patient.setPatientAddress(patient.getPatientAddress());
            _patient.setContactNo(patient.getContactNo());
            _patient.setDoctorId(patient.getDoctorId());
            return new ResponseEntity<>(patientRepository.save(_patient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") String id) {
        try {
            patientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patients")
    public ResponseEntity<HttpStatus> deleteAllPatients() {
        try {
            patientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
