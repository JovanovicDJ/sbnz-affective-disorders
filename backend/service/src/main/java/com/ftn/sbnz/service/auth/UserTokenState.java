package com.ftn.sbnz.service.auth;

import com.ftn.sbnz.model.Doctor;

public class UserTokenState {
    private String accessToken;
    private Long expiresIn;
    private Doctor doctor;

    public UserTokenState() {
        this.accessToken = null;
        this.expiresIn = null;
    }

    public UserTokenState(String accessToken, long expiresIn, Doctor doctor) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.doctor = doctor;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setUser(Doctor doctor) {
        this.doctor = doctor;
    }
}
