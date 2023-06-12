package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.Patient;
import com.ftn.sbnz.service.dto.PatientDTO;
import com.ftn.sbnz.service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient findByEmail(String email) {
        return this.patientRepository.findByEmail(email);
    }

    public List<Patient> findByDoctorID(Long doctorID){
        return this.patientRepository.findByDoctorID(doctorID);
    }
    public Patient save(PatientDTO patientDTO) {
        Patient patient = new Patient();

        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setDob(patientDTO.getDob());
        patient.setGender(patientDTO.getGender());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhoneNum(patientDTO.getPhoneNum());
        patient.setDoctorID(patientDTO.getDoctorID());

        return patientRepository.save(patient);
    }
}
