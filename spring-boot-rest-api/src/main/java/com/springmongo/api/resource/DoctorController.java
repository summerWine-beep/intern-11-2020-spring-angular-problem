package com.springmongo.api.resource;

import java.util.List;
import java.util.Optional;

import com.springmongo.api.model.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.springmongo.api.repository.DoctorRepository;

import javax.print.Doc;


@RestController
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping("/addDoctor")
    public String saveDoctor(@RequestBody DoctorModel doctormodel){
        repository.save(doctormodel);
        return "Added doctor with id :" +doctormodel.getId();
    }

    @GetMapping("/findAllDoctors")
    public List<DoctorModel> getDoctors(){
        return repository.findAll();
    }

    @GetMapping("/findAllDoctors/{id}")
    public Optional<DoctorModel> getDoctor(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable int id){
        repository.deleteById(id);
        return "Doctor deleted with id: "+id;
    }

    @PutMapping("/updateDoctor/{id}")
    public ResponseEntity<DoctorModel> updateTutorial(@PathVariable("id") int id, @RequestBody DoctorModel doctorModel) {
        Optional<DoctorModel> doctorData = repository.findById(id);

        if (doctorData.isPresent()) {
            DoctorModel _doctor_model = doctorData.get();
            _doctor_model.setDoctor_name(doctorModel.getDoctor_name());
            _doctor_model.setDoctor_address(doctorModel.getDoctor_address());
            return new ResponseEntity<>(repository.save(_doctor_model), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
