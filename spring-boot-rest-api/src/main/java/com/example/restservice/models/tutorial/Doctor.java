package com.example.restservice.models.tutorial;


import javax.persistence.*;

@Entity
@Table(name = "javaAngular")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "doctor_name")
    private String doctor_name;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "doctor_address")
    private String doctor_address;

    @Column(name = "hospital_name")
    private String hospital_name;

    @Column(name = "about")
    private String about;



    public Doctor() {

    }


    public Doctor(String doctor_name, String speciality, String doctor_address, String hospital_name, String about) {
        this.doctor_name = doctor_name;
        this.speciality = speciality;
        this.doctor_address = doctor_address;
        this.hospital_name = hospital_name;
        this.about = about;

    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", doctor_name=" + doctor_name + ", speciality=" + speciality + ", speciality=" + speciality + ", doctor_address="+ doctor_address + ", hospital_name= " + hospital_name+ ", about=" + about + "]" ;
    }
}
