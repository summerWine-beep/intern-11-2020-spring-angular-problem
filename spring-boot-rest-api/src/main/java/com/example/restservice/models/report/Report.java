package com.example.restservice.models.report;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "report")

public class Report {

    @Id
    private String id;

    private String patientId;
    private String doctorId;
    private String createdDatetime;
    private String bloodPressure;
    private String pulseRate;
    private String weight;
    private String allergies;
    private String disabilities;
    private String medicin;
    private String diet;
    private String patientHistory;
    private String followupDoctorId;

    public Report(){

    }

    public Report(String patientId, String doctorId, String createdDatetime,
                  String bloodPressure, String pulseRate, String weight, String allergies,
                  String disabilities, String medicin,
                  String diet, String patientHistory, String followupDoctorId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.createdDatetime = createdDatetime;
        this.bloodPressure = bloodPressure;
        this.pulseRate = pulseRate;
        this.weight = weight;
        this.allergies = allergies;
        this.disabilities = disabilities;
        this.medicin = medicin;
        this.diet = diet;
        this.patientHistory = patientHistory;
        this.followupDoctorId = followupDoctorId;
    }

    public String getId() {
        return id;
    }


    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(String createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(String disabilities) {
        this.disabilities = disabilities;
    }

    public String getMedicin() {
        return medicin;
    }

    public void setMedicin(String medicin) {
        this.medicin = medicin;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(String patientHistory) {
        this.patientHistory = patientHistory;
    }

    public String getFollowupDoctorId() {
        return followupDoctorId;
    }

    public void setFollowupDoctorId(String followupDoctorId) {
        this.followupDoctorId = followupDoctorId;
    }
}
