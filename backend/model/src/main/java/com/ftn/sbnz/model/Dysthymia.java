package com.ftn.sbnz.model;

import java.time.LocalDate;

public class Dysthymia {
    private int id;
    private int patinetId;
    private LocalDate date;
    private int intensitySum;

    public Dysthymia(int id, int patinetId, LocalDate date, int intensitySum) {
        this.id = id;
        this.patinetId = patinetId;
        this.date = date;
        this.intensitySum = intensitySum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatinetId() {
        return patinetId;
    }

    public void setPatinetId(int patinetId) {
        this.patinetId = patinetId;
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
