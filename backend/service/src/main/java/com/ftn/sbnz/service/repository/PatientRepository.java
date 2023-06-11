package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);
}
