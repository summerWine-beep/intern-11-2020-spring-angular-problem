package com.springmongo.api.model;

public class MedicineModel {
    private String drug_name;
    private int unit;
    private String dosage;

    @Embeddable
    public MedicineModel(){
        super();
    }
    public MedicineModel(String drug_name, int unit, String dosage){
        super();
        this.drug_name = drug_name;
        this.unit = unit;
        this.dosage = dosage;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
