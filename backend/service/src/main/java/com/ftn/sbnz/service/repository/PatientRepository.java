package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);

    List<Patient> findByDoctorID(Long doctorID);


}
