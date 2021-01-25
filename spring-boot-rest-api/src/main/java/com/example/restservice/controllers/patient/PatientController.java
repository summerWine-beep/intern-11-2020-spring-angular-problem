package com.example.restservice.controllers.patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.String;

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

import com.example.restservice.models.patient.Patient;
import com.example.restservice.repository.PatientRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllpatients(@RequestParam(required = false) String name) {
        try {
            List<Patient> patients = new ArrayList<Patient>();

            if (name == null)
                patientRepository.findAll().forEach(patients::add);
            else
                patientRepository.findByNameContaining(name).forEach(patients::add);

            if (patients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patients/{patient_id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("patient_id") String patient_id) {
        Optional<Patient> PatientData = patientRepository.findById(patient_id);

        if (PatientData.isPresent()) {
            return new ResponseEntity<>(PatientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient Patient) {
        try {
            Patient _Patient = patientRepository
                    .save(new Patient(
                        Patient.getName(),
                        Patient.getEntry(),
                        Patient.getAge(),
                        Patient.getDob(),
                        Patient.getGender(),
                        Patient.getOccupation(),
                        Patient.getInsurance(),
                        Patient.getProvider(),
                        Patient.getAddress(),
                        Patient.getContact(),
                        Patient.getDid()
            ));
            return new ResponseEntity<>(_Patient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/patients/{patient_id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("patient_id") String patient_id, @RequestBody Patient Patient) {
        Optional<Patient> PatientData = patientRepository.findById(patient_id);

        if (PatientData.isPresent()) {
            Patient _Patient = PatientData.get();
            _Patient.setName(Patient.getName());
            _Patient.setEntry(Patient.getEntry());
            _Patient.setAge(Patient.getAge());
            _Patient.setDob(Patient.getDob());
            _Patient.setAddress(Patient.getAddress());
            _Patient.setAge(Patient.getAge());
            _Patient.setGender(Patient.getGender());
            _Patient.setOccupation(Patient.getOccupation());
            _Patient.setInsurance(Patient.getInsurance());
            _Patient.setProvider(Patient.getProvider());
            _Patient.setAddress(Patient.getAddress());
            _Patient.setContact(Patient.getContact());
            _Patient.setDid(Patient.getDid());

            return new ResponseEntity<>(patientRepository.save(_Patient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patients/{patient_id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("patient_id") String patient_id) {
        try {
            patientRepository.deleteById(patient_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/patients")
    public ResponseEntity<HttpStatus> deleteAllpatients() {
        try {
            patientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/patients/namedob/{name}/{dob}")
    public ResponseEntity<List<Patient>> getByPatientNameandDob(@PathVariable("name") String name, @PathVariable("dob") String dob) {
        List<Patient> patients = new ArrayList<Patient>();
        List<Patient> patientData = patientRepository.findByNameAndDobContaining(name,dob);

        if (!patientData.isEmpty()) {
            patientRepository.findByNameAndDobContaining(name, dob).forEach(patients::add);
            return new ResponseEntity<>(patients, HttpStatus.OK);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}