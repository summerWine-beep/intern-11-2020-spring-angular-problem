package com.springmongo.api.resource;

import java.util.List;
import java.util.Optional;

import com.springmongo.api.model.DoctorModel;
import com.springmongo.api.model.PatientModel;
import com.springmongo.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/patients")
    public String savePatient(@RequestBody PatientModel patientModel) {
        patientRepository.save(patientModel);
        return "Adding new doctor records :" + patientModel.getId();
    }

    @GetMapping("/patients")
    public List<PatientModel> getPatient(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/id/{id}")
    public Optional<PatientModel> getPatient(@PathVariable int id){
        return patientRepository.findById(id);
    }

    //not working
    @GetMapping("/patients/name/{patient_name}")
    public Optional<PatientModel> getPatient(@PathVariable String patient_name){
        return patientRepository.findByPatientName(patient_name);
    }

    //@GetMapping("/patients/namedob/{patient_name,dob}")


    @DeleteMapping("/patients/id/{id}")
    public String deletePatient(@PathVariable int id) {
        patientRepository.deleteById(id);
        return "Doctor deleted with id: " + id;
    }


    @DeleteMapping("/deletePatients")
    public ResponseEntity<HttpStatus> deleteAllPatients() {
        try {
            patientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/patients/id/{id}")
    public ResponseEntity<PatientModel> updatePatient(@PathVariable("id") int id, @RequestBody PatientModel patientModel) {
        Optional<PatientModel> patientData = patientRepository.findById(id);

        if (patientData.isPresent()) {
            PatientModel patientModel1 = patientData.get();
            patientModel1.setPatient_name(patientModel.getPatient_name());
            patientModel1.setDate_of_birth(patientModel.getDate_of_birth());
            patientModel1.setAge(patientModel.getAge());
            patientModel1.setGender(patientModel.getGender());
            patientModel1.setOccupation(patientModel.getOccupation());
            patientModel1.setHealth_insurance_no(patientModel.getHealth_insurance_no());
            patientModel1.setPatient_address(patientModel.getPatient_address());
            patientModel1.setContact_no(patientModel.getContact_no());
            patientModel1.setDoctor_id(patientModel.getDoctor_id());

            return new ResponseEntity<>(patientRepository.save(patientModel), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
