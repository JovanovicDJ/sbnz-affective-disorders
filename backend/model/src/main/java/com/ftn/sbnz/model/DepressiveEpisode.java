package com.ftn.sbnz.model;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "depressive_episodes")
@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("60d")
public class DepressiveEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "de_id", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false)
    private DepressionType depressionType;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @Column(name ="execution_time",nullable = false)
    private Date executionTime;

    @Column(name ="intensity",nullable = false)
    private int intensitySum;

    @Column(name ="accepted",nullable = false)
    private boolean accepted;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    public DepressiveEpisode() { }

    public DepressiveEpisode(DepressionType depressionType, Patient patient, int intensitySum, boolean accepted) {
        this.depressionType = depressionType;
        this.patient = patient;
        this.executionTime = new Date();
        this.intensitySum = intensitySum;
        this.accepted = accepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepressionType getDepressionType() {
        return depressionType;
    }

    public void setDepressionType(DepressionType depressionType) {
        this.depressionType = depressionType;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
