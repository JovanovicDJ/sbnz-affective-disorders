package com.ftn.sbnz.model;

public class Symptom {
    private String name;
    private int intensity;
    private SymptomGroup symptomGroup;

    public Symptom(String name, int intensity, SymptomGroup symptomGroup) {
        this.name = name;
        this.intensity = intensity;
        this.symptomGroup = symptomGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public SymptomGroup getSymptomGroup() {
        return symptomGroup;
    }

    public void setSymptomGroup(SymptomGroup symptomGroup) {
        this.symptomGroup = symptomGroup;
    }
}
