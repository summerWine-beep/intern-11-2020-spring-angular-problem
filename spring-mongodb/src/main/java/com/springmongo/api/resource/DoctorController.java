package com.springmongo.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springmongo.api.model.DoctorModel;
import com.springmongo.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/doctors")
    public String saveDoctor(@RequestBody DoctorModel doctormodel) {
        doctorRepository.save(doctormodel);
        return "Adding new doctor records :" + doctormodel.getId();
    }

    @GetMapping("/doctors")
    public List<DoctorModel> getDoctor() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/id/{id}")
    public Optional<DoctorModel> getDoctor(@PathVariable Integer id) {
        return doctorRepository.findById(id);
    }

//    not working
//    @GetMapping("/doctors/name/{doctor_name}")
//    public void getDoctorName(@PathVariable String doctor_name) {
//        doctorRepository.findByDoctorName(doctor_name);
//    }



    @DeleteMapping("/deletedoctors/id/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorRepository.deleteById(id);
        return "Doctor deleted with id: " + id;
    }

    @DeleteMapping("/deletedoctors")
    public ResponseEntity<HttpStatus> deleteAllDoctors() {
        try {
            doctorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/doctors/id/{id}")
    public ResponseEntity<DoctorModel> updateDoctor(@PathVariable("id") int id, @RequestBody DoctorModel doctorModel) {
        Optional<DoctorModel> doctorData = doctorRepository.findById(id);

        if (doctorData.isPresent()) {
            DoctorModel doctorModel1 = doctorData.get();
            doctorModel1.setDoctor_name(doctorModel.getDoctor_name());
            doctorModel1.setSpeciality(doctorModel.getSpeciality());
            doctorModel1.setDoctor_address(doctorModel.getDoctor_address());
            doctorModel1.setHospital_name(doctorModel.getHospital_name());
            doctorModel1.setAbout(doctorModel.getAbout());

            return new ResponseEntity<>(doctorRepository.save(doctorModel1), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
