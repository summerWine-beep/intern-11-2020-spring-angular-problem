package com.springmongo.api.service;

import com.springmongo.api.model.ReportsModel;
import com.springmongo.api.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public ReportService reportService;

    public Optional<ReportsModel> findById(String id) {
        return reportRepository.findById(id);
    }

    public ReportsModel addReport(ReportsModel reports) {
        return (ReportsModel) reportRepository.insert(reports);
    }

    public ReportsModel update(ReportsModel reports) {
        return (ReportsModel) reportRepository.save(reports);

    }

    public void delete(String id) {
        reportRepository.deleteById(id);
    }


    public void deleteAll() {
    }

    public List<ReportsModel> getAllReports() {
        return reportRepository.findAll();
    }


    public Iterable<ReportsModel> findBy(int patient_id) {
        return reportRepository.findAllById(patient_id);
    }
}
