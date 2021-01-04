package com.springmongo.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Document(collection = "Report")
public class ReportsModel {
    @Id
    private String id;
    private int patient_id;
    private int doctor_id;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date created_datetime = new Date(System.currentTimeMillis());
    private float blood_pressure;
    private float pulse_rate;
    private float weight;
    private List<String> allergies;
    private List<String> disabilities;
    @Embedded
    private MedicineModel medicine;
    @Embedded
    private DietModel diet;

    private String patient_history;
    private int follow_up_doctor_id;

    public ReportsModel(){
        super();
    }

    public ReportsModel(int report_id, int patient_id, int doctor_id, Date created_datetime, float blood_pressure, float pulse_rate,
                        float weight, String allergies, String disabilities, MedicineModel medicine, DietModel diet, String patient_history,
                        int follow_up_doctor_id)
    {
        super();
        this.id = id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.created_datetime = created_datetime;
        this.blood_pressure = blood_pressure;
        this.pulse_rate = pulse_rate;
        this.weight = weight;
        this.allergies = Collections.singletonList(allergies);
        this.disabilities = Collections.singletonList(disabilities);
        this.medicine = medicine;
        this.diet = diet;
        this.patient_history = patient_history;
        this.follow_up_doctor_id = follow_up_doctor_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Date getCreated_datetime() {
        return created_datetime;
    }

    public void setCreated_datetime(Date created_datetime) {
        this.created_datetime = created_datetime;
    }

    public float getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(float blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public float getPulse_rate() {
        return pulse_rate;
    }

    public void setPulse_rate(float pulse_rate) {
        this.pulse_rate = pulse_rate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
    }

    public MedicineModel getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineModel medicine) {
        this.medicine = medicine;
    }

    public DietModel getDiet() {
        return diet;
    }

    public void setDiet(DietModel diet) {
        this.diet = diet;
    }

    public String getPatient_history() {
        return patient_history;
    }

    public void setPatient_history(String patient_history) {
        this.patient_history = patient_history;
    }

    public int getFollow_up_doctor_id() {
        return follow_up_doctor_id;
    }

    public void setFollow_up_doctor_id(int follow_up_doctor_id) {
        this.follow_up_doctor_id = follow_up_doctor_id;
    }
}


