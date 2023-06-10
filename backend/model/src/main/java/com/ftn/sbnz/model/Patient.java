package com.ftn.sbnz.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false)
    private Long id;

    @Column(name ="name",nullable = false)
    private String name;

    @Column(name ="surname",nullable = false)
    private String surname;

    @Column(name ="dob",nullable = false)
    private LocalDate dob;

    @Column(name ="gender",nullable = false)
    private GenderType gender;

    @Column(name ="email",nullable = false)
    private String email;

    @Column(name ="phone",nullable = false)
    private String phoneNum;

    public Patient() { }

    public Patient(long id, String name, String surname, LocalDate dob, GenderType gender, String email, String phoneNum) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
