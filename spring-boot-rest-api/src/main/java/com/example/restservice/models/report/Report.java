package com.example.restservice.models.report;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

/**
 * report_id
 * patient_id
 * doctor_id
 * created_datetime
 * blood_presure
 * pulse_rate
 * weight
 * allergies(list)
 * disabilities(list)
 * medicine(list of document)
 * diet(list of document)
 * patient_history
 * follow_up_doctor_id
 */


@Document(collection = "reports")
public class Report {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    @CreatedDate
    private Date createdDate;
    private Double bloodPressure;
    private Double pulseRate;
    private Double weight;
    private List<String> allergies;
    private List<String> disabilities;
    private List<Medicine> medicines;
    private List<Diet> diets;
    private String patientHistory;
    private String followupDoctorId;

    public Report(){

    }

    public Report(String patientId, String doctorId,
                  Date createdDate, Double bloodPressure, Double pulseRate,
                  Double weight, List<String> allergies, List<String> disabilities,
                  List<Medicine> medicines, List<Diet> diets, String patientHistory,
                  String followupDoctorId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.createdDate = createdDate;
        this.bloodPressure = bloodPressure;
        this.pulseRate = pulseRate;
        this.weight = weight;
        this.allergies = allergies;
        this.disabilities = disabilities;
        this.medicines = medicines;
        this.diets = diets;
        this.patientHistory = patientHistory;
        this.followupDoctorId = followupDoctorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(Double pulseRate) {
        this.pulseRate = pulseRate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<Diet> getDiets() {
        return diets;
    }

    public void setDiets(List<Diet> diets) {
        this.diets = diets;
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

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", createdDate=" + createdDate +
                ", bloodPressure=" + bloodPressure +
                ", pulseRate=" + pulseRate +
                ", weight=" + weight +
                ", allergies=" + allergies +
                ", disabilities=" + disabilities +
                ", medicines=" + medicines +
                ", diets=" + diets +
                ", patientHistory='" + patientHistory + '\'' +
                ", followupDoctorId='" + followupDoctorId + '\'' +
                '}';
    }

}
