package com.ftn.sbnz.model2;

import java.time.LocalDate;

public class Psychopathy {

    private int id;
    private int patientId;
    private LocalDate date;
    private int intensitySum;

    public Psychopathy( int patientId, LocalDate date, int intensitySum) {
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
}
