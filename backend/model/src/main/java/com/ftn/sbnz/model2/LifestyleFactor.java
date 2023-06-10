package com.ftn.sbnz.model2;

import com.ftn.sbnz.model.Patient;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lifestyle_factors")
public class LifestyleFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lf_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "intensity", nullable = false)
    private int intensitySum;

    public LifestyleFactor() { }

    public LifestyleFactor(Patient patient, LocalDate date, int intensitySum) {
        this.patient = patient;
        this.date = date;
        this.intensitySum = intensitySum;
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

    @Override
    public String toString() {
        return "LifestyleFactor{" +
                "id=" + id +
                ", patientId=" + patient.getId() +
                ", date=" + date +
                ", intensitySum=" + intensitySum +
                '}';
    }
}
