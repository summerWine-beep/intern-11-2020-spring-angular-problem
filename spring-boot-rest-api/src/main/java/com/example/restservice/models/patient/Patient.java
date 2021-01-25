package com.example.restservice.models.patient;


import org.springframework.data.annotation.Id;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patient_id;

    @Column(name = "patient_name")
    private String name;

    @Column(name = "entry_datetime")
    private Date entry;

    @Column(name = "date_of_birth")
    private Date dob;

    @Column(name = "age")
    private Long age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "health_insurance_no")
    private Long insurance;

    @Column(name = "health_care_provider")
    private String provider;

    @Column(name = "patient_address")
    private String address;

    @Column(name = "contact_no")
    private Integer contact;

    @Column(name = "doctor_id")
    private Long did;
    @javax.persistence.Id
    private Long id;

    public Patient() {

    }

    public Patient (String name, Date entry, Date dob, String gender, String occupation, Long insurance, String provider, String address, Integer contact, Long did) {
        this.name = name;
        this.entry = entry;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.insurance = insurance;
        this.provider = provider;
        this.address = address;
        this.contact = contact;
        this.did = did;
    }

    public Patient(String name, Date entry, Long age, Date dob, String gender, String occupation, Long insurance, String provider, String address, Integer contact, Long did) {
    }

    public Long getId() {
        return patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEntry(){
        return entry;
    }

    public void setEntry(Date entry){
        this.entry = entry;
    }

    public Date getDob(){
        return dob;
    }
    public void setDob(Date dob){
        this.dob = dob;
    }

    public Long getAge(){
        return age;
    }

    public void setAge(Long age){
        this.age = age;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getOccupation(){
        return occupation;
    }

    public void setOccupation(String occupation){
        this.occupation = occupation;
    }

    public Long getInsurance(){
        return insurance;
    }

    public void setInsurance(Long insurance){
        this.insurance = insurance;
    }

    public  String getProvider(){
        return provider;
    }

    public void setProvider(String provider){
        this.provider = provider;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String paddress) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Patient [patient_id=" + patient_id + ", name=" + name + ", entry=" + entry + ", date_of_birth=" + dob +  ", ee=" + age + ", gender=" + gender +", occupation=" + occupation +", insurance=" + insurance +", provider=" + provider +", address=" + address +", contact=" + contact +", did=" + did +"]";
    }

}
