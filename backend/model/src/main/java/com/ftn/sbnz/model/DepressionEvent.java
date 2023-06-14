package com.ftn.sbnz.model;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import java.util.Date;

@Role(Role.Type.EVENT)
@Expires("30m")
public class DepressionEvent {
    private Patient patient;
    private int intensity;

    public DepressionEvent(Patient patient, int intensity) {
        this.patient = patient;
        this.intensity = intensity;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
