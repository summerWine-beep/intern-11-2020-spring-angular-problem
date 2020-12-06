package com.springmongo.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Doctor")
public class DoctorModel {
    @Id
    public int id;
    public String doctor_name;
    public String speciality;
    public String doctor_address;
    public String hospital_name;
    public String about;
    public String profile_picture;



    public DoctorModel(String doctor_name, String speciality, String doctor_address, String hospital_name, String about, String profile_picture) {
        this.doctor_name = doctor_name;
        this.speciality = speciality;
        this.doctor_address = doctor_address;
        this.hospital_name = hospital_name;
        this.about = about;
        this.profile_picture = profile_picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    @Override
    public String toString() {
        return "DoctorModel{" +
                "id=" + id +
                ", doctor_name='" + doctor_name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", doctor_address='" + doctor_address + '\'' +
                ", hospital_name='" + hospital_name + '\'' +
                ", about='" + about + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                '}';
    }
}
