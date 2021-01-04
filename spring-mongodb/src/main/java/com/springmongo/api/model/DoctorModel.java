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
    private String id;
    private String doctor_name;
    private String speciality;
    private String doctor_address;
    private String hospital_name;
    private String about;
    private String profile_picture;

    public DoctorModel(){
        super();
    }

    public DoctorModel(String id, String doctor_name, String speciality, String doctor_address, String hospital_name, String about, String profile_picture) {
        this.id = id;
        this.doctor_name = doctor_name;
        this.speciality = speciality;
        this.doctor_address = doctor_address;
        this.hospital_name = hospital_name;
        this.about = about;
        this.profile_picture = profile_picture;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getDoctor_name(){
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name){
        this.doctor_name = doctor_name;
    }

    public String getSpeciality(){
        return speciality;
    }

    public void setSpeciality(String speciality ){
        this.speciality = speciality;
    }

    public String getDoctor_address(){
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address){
        this.doctor_address = doctor_address;
    }

    public String getHospital_name(){
        return hospital_name;
    }

    public void setHospital_name(String hospital_name){
        this.hospital_name = hospital_name;
    }

    public String getAbout(){
        return about;
    }

    public void setAbout(String about){
        this.about = about;
    }

    public String getProfile_picture(){
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture){
        this.profile_picture = profile_picture;
    }

    public String toString(){
        return "Doctor Details: "+id+" Name:"+doctor_name+"Doctor Speciality:" +speciality+" Address:" +doctor_address+" Hospital Name:"+hospital_name+" About:"+about;
    }


}
