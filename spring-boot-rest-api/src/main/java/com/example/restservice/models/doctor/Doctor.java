package com.example.restservice.models.doctor;


import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long doctor_id;

    @Column(name = "name")
    private String name;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "address")
    private String address;

    @Column(name = "hospital_name")
    private String hosname;

    @Column(name = "about")
    private String about;

    public Doctor() {

    }

    public Doctor(String name, String speciality, String address, String hosname, String about) {
        this.name = name;
        this.speciality = speciality;
        this.address = address;
        this.hosname = hosname;
        this.about = about;

    }

    public long getId() {
        return doctor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getHosname() {
        return hosname;
    }
    public void setHosname(String hosname) {
        this.hosname = hosname;
    }

    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Doctor [doctor_id=" + doctor_id + ", name=" + name + ", speciality=" + speciality + ", address=" + address +  ", hosname=" + hosname + ", about=" + about +"]";
    }
}
