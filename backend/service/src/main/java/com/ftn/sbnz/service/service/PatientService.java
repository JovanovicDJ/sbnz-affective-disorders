package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.dto.HistoryDTO;
import com.ftn.sbnz.service.dto.PatientDTO;
import com.ftn.sbnz.service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private HistoryService historyService;

    @Autowired
    private PatientRepository patientRepository;


    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
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

    public Patient findById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            return null;
        }
    }

    public List<HistoryDTO> getPatientHistory(Long id) {
        return historyService.getPatientHistory(id);
    }
}
