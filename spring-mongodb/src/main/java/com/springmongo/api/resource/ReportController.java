package com.springmongo.api.resource;

import com.springmongo.api.model.ReportsModel;
import com.springmongo.api.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    ReportService reportService;

    //works
    @GetMapping("/reports")
    public List<ReportsModel> getAllReports(){
        return reportService.getAllReports();
    }

    //works
    @GetMapping("/reports/id/{id}")
    public Optional<ReportsModel> getReport(@PathVariable String id){
        return reportService.findById(id);
    }

    //not working
//    @GetMapping("/reports/patient_id/{patient_id}")
//    public Iterable<ReportsModel> getReportPatient(@PathVariable int patient_id){
//        return reportService.findBy(patient_id);
//    }



    //works
    @PostMapping("/reports")
    public ReportsModel addReport(@RequestBody ReportsModel reports){
        return reportService.addReport(reports);
    }

    //works
    @PutMapping("/reports/id/{id}")
    public ReportsModel update(@RequestBody ReportsModel reports){
        return reportService.update(reports);
    }


    //not working
    @DeleteMapping("/delete/id/{id}")
    public String delete(@RequestParam String id){
        reportService.delete(id);
       return "Deleted";
    }

    //
    @DeleteMapping("/deleteReports")
    public void deleteAll(){
        reportService.deleteAll();
    }
}
