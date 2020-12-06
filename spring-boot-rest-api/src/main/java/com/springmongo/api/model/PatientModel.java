package com.springmongo.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Patient")
public class PatientModel {
    @Id
    private int id;
    private String patient_name;
    private String entry_datetime;
    private String date_of_birth;
    private String age;
    private String gender;
    private String occupation;
    private String health_insurance_no;
    private String health_care_provider;
    private String patient_address;
    private String contact_no;
    private String doctor_id;

    public PatientModel(String patient_name, String entry_datetime, String date_of_birth, String age, String gender, String occupation, String health_insurance_no, String health_care_provider, String patient_address, String contact_no, String doctor_id) {
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

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getEntry_datetime() {
        return entry_datetime;
    }

    public void setEntry_datetime(String entry_datetime) {
        this.entry_datetime = entry_datetime;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
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
        return "PatientModel{" +
                "id=" + id +
                ", patient_name='" + patient_name + '\'' +
                ", entry_datetime='" + entry_datetime + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", age='" + age + '\'' +
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
