package com.ftn.sbnz.model;

import java.time.LocalDate;

public class Patient {
    private int id;
    private String name;
    private String surname;
    private LocalDate dob;
    private GenderType gender;
    private String email;
    private String password;
    private String phoneNum;

    public Patient(int id, String name, String surname, LocalDate dob, GenderType gender, String email, String password, String phoneNum) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
