package com.springmongo.api.resource;

import java.util.List;
import java.util.Optional;

import com.springmongo.api.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springmongo.api.repository.PatientRepository;


@RestController
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping("/addPatients")
    public String savePatient(@RequestBody PatientModel patientmodel){
        repository.save(patientmodel);
        return "Added patient with id :" +patientmodel.getId();
    }

    @GetMapping("/allPatients")
    public List<PatientModel> getPatient(){
        return repository.findAll();
    }

    @GetMapping("/Patients/{id}")
    public Optional<PatientModel> getPatient(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/deletePatients/{id}")
    public String deletePatient(@PathVariable int id){
        repository.deleteById(id);
        return "Patient deleted with id: "+id;
    }
    

}
