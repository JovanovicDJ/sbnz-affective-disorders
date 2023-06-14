package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.AffectiveFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffectiveFactorRepository extends JpaRepository<AffectiveFactor, Long> {

    List<AffectiveFactor> getAffectiveFactorsByPatient_Id(Long id);
}
