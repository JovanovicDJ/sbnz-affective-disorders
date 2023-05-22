package com.ftn.sbnz.model;

import java.time.LocalDate;

public class BipolarDisorder {
    private int id;
    private BipolarDisorderType bipolarDisorderType;
    private int patientId;
    private LocalDate date;
    private int intensitySum;

    public BipolarDisorder(BipolarDisorderType bipolarDisorderType, int patientId, LocalDate date, int intensitySum) {
        this.bipolarDisorderType = bipolarDisorderType;
        this.patientId = patientId;
        this.date = date;
        this.intensitySum = intensitySum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BipolarDisorderType getBipolarDisorderType() {
        return bipolarDisorderType;
    }

    public void setBipolarDisorderType(BipolarDisorderType bipolarDisorderType) {
        this.bipolarDisorderType = bipolarDisorderType;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getIntensitySum() {
        return intensitySum;
    }

    public void setIntensitySum(int intensitySum) {
        this.intensitySum = intensitySum;
    }
}
