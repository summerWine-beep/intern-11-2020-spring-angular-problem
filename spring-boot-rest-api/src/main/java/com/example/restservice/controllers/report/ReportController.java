package com.example.restservice.controllers.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.restservice.repository.PatientRepository;
import com.example.restservice.repository.ReportRepository;
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

import com.example.restservice.models.report.Report;

import com.example.restservice.models.patient.Patient;
import com.example.restservice.repository.PatientRepository;

@RestController
@RequestMapping("/api")


public class ReportController {

    @Autowired
    ReportRepository reportRepository;


    @PostMapping("/report")
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        try {
            Report _report = reportRepository.save(new Report(
                    report.getPatientId(),
                    report.getDoctorId(),
                    report.getBloodPressure(),
                    report.getPulseRate(),
                    report.getWeight(),
                    report.getAllergies(),
                    report.getDisabilities(),
                    report.getMedicine(),
                    report.getDiet(),
                    report.getPatientHistory(),
                    report.getFollowupDoctorId(),
                    report.getCreatedDatetime()

            ));
            return new ResponseEntity<>(_report, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/report")
    public ResponseEntity<List<Report>> getAllReports() {
        try {
            List<Report> reports = new ArrayList<Report>();
            reportRepository.findAll().forEach(reports::add);

            if (reports.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable("id") String id) {
        Optional<Report> reportData = reportRepository.findById(id);

        if (reportData.isPresent()) {
            return new ResponseEntity<>(reportData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/report/patient/{patientid}")
    public ResponseEntity<Report> getReportByPatientId(@PathVariable("patientId") String patientid) {
        Optional<Report> reportData = reportRepository.findByPatientId(patientid);

        if (reportData.isPresent()) {
            return new ResponseEntity<>(reportData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/report/namedob")
    public ResponseEntity<Report> getReportByPatientNameandDob(@RequestBody Patient p) {
        Optional<Patient> patientData = patientRepository.findByPatientNameContainingAndDob(p.getPatientName(), p.getDob());
        if (patientData.isPresent()) {
            Patient patient = patientData.get();
            Optional<Report> reportData = reportRepository.findByPatientId(patient.getId());
            if (reportData.isPresent()) {
                return new ResponseEntity<>(reportData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/report/{id}")
    public ResponseEntity<Report> updatePatient(@PathVariable("id") String id, @RequestBody Report report) {
        Optional<Report> reportData = reportRepository.findById(id);

        if (reportData.isPresent()) {
            Report _report = reportData.get();

            if (report.getPatientId() != null) {
                _report.setPatientId(report.getPatientId());
            }

            if (report.getBloodPressure() != null) {
                _report.setBloodPressure(report.getBloodPressure());
            }

            if (report.getPulseRate() != null) {
                _report.setPulseRate(report.getPulseRate());
            }

            if (report.getWeight() != null) {
                _report.setWeight(report.getWeight());
            }

            if (report.getAllergies() != null) {
                _report.setAllergies(report.getAllergies());
            }

            if (report.getDisabilities() != null) {
                _report.setDisabilities(report.getDisabilities());
            }

            if (report.getMedicine() != null) {
                _report.setMedicine((report.getMedicine()));
            }

            if (report.getDiet() != null) {
                _report.setDiet(report.getDiet());
            }

            if (report.getPatientHistory() != null) {
                _report.setPatientHistory(report.getPatientHistory());
            }

            if (report.getFollowupDoctorId() != null) {
                _report.setFollowupDoctorId(report.getFollowupDoctorId());
            }

            return new ResponseEntity<>(reportRepository.save(_report), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/report/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") String id) {
        try {
            reportRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/report")
    public ResponseEntity<HttpStatus> deleteAllPatients() {
        try {
            reportRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
