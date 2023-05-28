package com.ftn.sbnz.model;

public class Symptom {
    private String name;
    private int intensity;
    private SymptomGroup symptomGroup;
    private int patientId;

    public Symptom(String name, int intensity, SymptomGroup symptomGroup, int patientId) {
        this.name = name;
        this.intensity = intensity;
        this.symptomGroup = symptomGroup;
        this.patientId = patientId;
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "name='" + name + '\'' +
                ", intensity=" + intensity +
                ", symptomGroup=" + symptomGroup +
                ", patientId=" + patientId +
                '}';
    }
}
