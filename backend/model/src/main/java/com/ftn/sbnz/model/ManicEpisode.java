package com.ftn.sbnz.model;

import java.time.LocalDate;

public class ManicEpisode {
    private int id;
    private ManiaType maniaType;
    private int patientId;
    private LocalDate date;
    private int intensitySum;

    public ManicEpisode(int id, ManiaType maniaType, int patientId, LocalDate date, int intensitySum) {
        this.id = id;
        this.maniaType = maniaType;
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

    public ManiaType getManiaType() {
        return maniaType;
    }

    public void setManiaType(ManiaType maniaType) {
        this.maniaType = maniaType;
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
