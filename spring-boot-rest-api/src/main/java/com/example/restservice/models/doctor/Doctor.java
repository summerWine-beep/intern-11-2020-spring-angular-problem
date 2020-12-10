package com.example.restservice.models.doctor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctor")

public class Doctor {
    @Id
    private String id;


    private String doctor_name;
    private String speciality;
    private String doctor_address;
    private String hospital_name;
    private String profile_picture;

    public Doctor(){

    }

    public Doctor(String id, String doctor_name, String speciality, String doctor_address, String hospital_name, String profile_picture) {
        this.id = id;
        this.doctor_name = doctor_name;
        this.speciality = speciality;
        this.doctor_address = doctor_address;
        this.hospital_name = hospital_name;
        this.profile_picture = profile_picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDoctor_address() {
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", doctor_address='" + doctor_address + '\'' +
                ", hospital_name='" + hospital_name + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                '}';
    }
}
