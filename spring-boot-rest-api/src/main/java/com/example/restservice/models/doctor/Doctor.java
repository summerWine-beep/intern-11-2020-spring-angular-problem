package com.example.restservice.models.doctor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;



@Document(collection = "doctors")
public class Doctor {
    @Id
    private String id;

    private String doctorName;
    private String speciality;
    private String doctorAddress;
    private String hospitalName;
    private String about;
    private String profilePicture;

    public Doctor() {

    }

    public Doctor(String doctorName, String speciality, String doctorAddress, String hospitalName,
                  String about, String profilePicture) {
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.doctorAddress = doctorAddress;
        this.hospitalName = hospitalName;
        this.about = about;
        this.profilePicture = profilePicture;
    }

    public String getId() {
        return id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", doctorAddress='" + doctorAddress + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", about='" + about + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}