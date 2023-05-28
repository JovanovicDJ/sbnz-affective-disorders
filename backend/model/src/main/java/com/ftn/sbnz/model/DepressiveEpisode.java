package com.ftn.sbnz.model;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.time.LocalDate;

@Role(Role.Type.EVENT)
@Expires("60d")
public class DepressiveEpisode {
    private int id;
    private DepressionType depressionType;
    private int patientId;
    private LocalDate date;
    private int intensitySum;
    private boolean accepted;

    public DepressiveEpisode(DepressionType depressionType, int patientId, LocalDate date, int intensitySum, boolean accepted) {
        this.depressionType = depressionType;
        this.patientId = patientId;
        this.date = date;
        this.intensitySum = intensitySum;
        this.accepted = accepted;
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

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
