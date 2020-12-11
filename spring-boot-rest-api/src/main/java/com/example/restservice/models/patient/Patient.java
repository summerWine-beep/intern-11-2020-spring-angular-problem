package com.example.restservice.models.patient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "patient")
public class Patient {

    @Id
    private String id;

    private String patientName;
    private Date entryDatetime;
    private Date dob;
    private String age;
    private String gender;
    private String occupation;
    private String healthInsuranceNo;
    private String healthCareProvider;
    private String patientAddress;
    private String contactNo;
    private String doctorId;

    public Patient(){

    }

    public Patient(String patientName, Date entryDatetime, Date dob, String age,
                   String gender, String occupation, String healthInsuranceNo,
                   String healthCareProvider,
                   String patientAddress, String contactNo, String doctorId)
    {
        this.patientName = patientName;
        this.entryDatetime = entryDatetime;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.healthInsuranceNo = healthInsuranceNo;
        this.healthCareProvider = healthCareProvider;
        this.patientAddress = patientAddress;
        this.contactNo = contactNo;
        this.doctorId = doctorId;
    }

    public String getId() {
        return id;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(Date entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHealthInsuranceNo() {
        return healthInsuranceNo;
    }

    public void setHealthInsuranceNo(String healthInsuranceNo) {
        this.healthInsuranceNo = healthInsuranceNo;
    }

    public String getHealthCareProvider() {
        return healthCareProvider;
    }

    public void setHealthCareProvider(String healthCareProvider) {
        this.healthCareProvider = healthCareProvider;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
