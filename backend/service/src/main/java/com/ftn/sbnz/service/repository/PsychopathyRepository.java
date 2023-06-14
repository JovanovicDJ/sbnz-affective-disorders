package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.Psychopathy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PsychopathyRepository extends JpaRepository<Psychopathy, Long> {

    List<Psychopathy> getPsychopathiesByPatient_Id(Long id);
}
