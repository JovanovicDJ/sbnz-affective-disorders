package com.ftn.sbnz.model;

import com.ftn.sbnz.model.Patient;
import org.kie.api.definition.type.Role;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "antisocial_factors")
@Role(Role.Type.EVENT)
public class AntisocialFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asf_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "intensity", nullable = false)
    private int intensitySum;

    public AntisocialFactor() { }

    public AntisocialFactor(Patient patient, LocalDate date, int intensitySum) {
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
        return "AntisocialFactor{" +
                "id=" + id +
                ", patientId=" + patient.getId() +
                ", date=" + date +
                ", intensitySum=" + intensitySum +
                '}';
    }
}
