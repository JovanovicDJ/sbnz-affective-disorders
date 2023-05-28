package com.ftn.sbnz.model2;

import java.time.LocalDate;

public class LifestyleFactor {
    private int id;
    private int patientId;
    private LocalDate date;
    private int intensitySum;

    public LifestyleFactor( int patientId, LocalDate date, int intensitySum) {

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

    @Override
    public String toString() {
        return "LifestyleFactor{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", date=" + date +
                ", intensitySum=" + intensitySum +
                '}';
    }
}
