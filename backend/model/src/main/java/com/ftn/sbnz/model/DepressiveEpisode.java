package com.ftn.sbnz.model;

import java.time.LocalDate;

public class DepressiveEpisode {
    private int id;
    private DepressionType depressionType;
    private int patientId;
    private LocalDate date;
    private int intensitySum;

    public DepressiveEpisode(DepressionType depressionType, int patientId, LocalDate date, int intensitySum) {
        this.depressionType = depressionType;
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

    public DepressionType getDepressionType() {
        return depressionType;
    }

    public void setDepressionType(DepressionType depressionType) {
        this.depressionType = depressionType;
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
