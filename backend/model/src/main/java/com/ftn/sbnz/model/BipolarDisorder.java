package com.ftn.sbnz.model;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.time.LocalDate;


@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("60d")
public class BipolarDisorder {
    private int id;
    private BipolarDisorderType bipolarDisorderType;
    private int patientId;
    private LocalDate executionTime;
    private int intensitySum;
    private boolean accepted;

    public BipolarDisorder(BipolarDisorderType bipolarDisorderType, int patientId, int intensitySum, boolean accepted) {
        this.bipolarDisorderType = bipolarDisorderType;
        this.patientId = patientId;
        this.executionTime = LocalDate.now();
        this.intensitySum = intensitySum;
        this.accepted = accepted;
    }

    public BipolarDisorder(BipolarDisorderType bipolarDisorderType, int patientId, LocalDate executionTime, int intensitySum, boolean accepted) {
        this.bipolarDisorderType = bipolarDisorderType;
        this.patientId = patientId;
        this.executionTime = executionTime;
        this.intensitySum = intensitySum;
        this.accepted = accepted;
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

    public LocalDate getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDate executionTime) {
        this.executionTime = executionTime;
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
