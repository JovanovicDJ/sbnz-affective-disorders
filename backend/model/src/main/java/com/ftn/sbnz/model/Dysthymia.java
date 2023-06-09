package com.ftn.sbnz.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dysthymias")
public class Dysthymia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "intensity", nullable = false)
    private int intensitySum;

    @Column(name = "accepted", nullable = false)
    private boolean accepted;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    public Dysthymia() { }

    public Dysthymia(Patient patient, LocalDate date, int intensitySum) {
        this.patient = patient;
        this.date = date;
        this.intensitySum = intensitySum;
        this.accepted = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
