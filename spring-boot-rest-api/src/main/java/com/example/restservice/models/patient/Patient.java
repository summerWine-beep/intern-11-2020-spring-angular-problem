package com.example.restservice.models.patient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "patient")
public class Patient {

    @Id
    private String id;

    private String patient_name;
    private Date entry_datetime;
    private Date date_of_birth;
    private Integer age;
    private String gender;
    private String occupation;
    private String health_insurance_no;
    private String health_care_provider;
    private String patient_address;
    private String contact_no;
    private String doctor_id;

    public Patient(){

    }

    public Patient(String id, String patient_name, Date entry_datetime, Date date_of_birth, Integer age, String gender, String occupation, String health_insurance_no, String health_care_provider, String patient_address, String contact_no, String doctor_id) {
        this.id = id;
        this.patient_name = patient_name;
        this.entry_datetime = entry_datetime;
        this.date_of_birth = date_of_birth;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.health_insurance_no = health_insurance_no;
        this.health_care_provider = health_care_provider;
        this.patient_address = patient_address;
        this.contact_no = contact_no;
        this.doctor_id = doctor_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public Date getEntry_datetime() {
        return entry_datetime;
    }

    public void setEntry_datetime(Date entry_datetime) {
        this.entry_datetime = entry_datetime;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public String getHealth_insurance_no() {
        return health_insurance_no;
    }

    public void setHealth_insurance_no(String health_insurance_no) {
        this.health_insurance_no = health_insurance_no;
    }

    public String getHealth_care_provider() {
        return health_care_provider;
    }

    public void setHealth_care_provider(String health_care_provider) {
        this.health_care_provider = health_care_provider;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", patient_name='" + patient_name + '\'' +
                ", entry_datetime=" + entry_datetime +
                ", date_of_birth=" + date_of_birth +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", occupation='" + occupation + '\'' +
                ", health_insurance_no='" + health_insurance_no + '\'' +
                ", health_care_provider='" + health_care_provider + '\'' +
                ", patient_address='" + patient_address + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", doctor_id='" + doctor_id + '\'' +
                '}';
    }
}
