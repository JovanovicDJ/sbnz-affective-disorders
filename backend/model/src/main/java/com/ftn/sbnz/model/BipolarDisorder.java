package com.ftn.sbnz.model;

import java.time.LocalDate;

public class BipolarDisorder {
    private int id;
    private BipolarDisorderType bipolarDisorderType;
    private int patienId;
    private LocalDate date;
    private int intensitySum;

    public BipolarDisorder(int id, BipolarDisorderType bipolarDisorderType, int patienId, LocalDate date, int intensitySum) {
        this.id = id;
        this.bipolarDisorderType = bipolarDisorderType;
        this.patienId = patienId;
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

    public int getPatienId() {
        return patienId;
    }

    public void setPatienId(int patienId) {
        this.patienId = patienId;
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
