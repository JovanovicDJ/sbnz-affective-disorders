package com.ftn.sbnz.service.repository;


import com.ftn.sbnz.model.InterpersonalAffectiveFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterpersonalAffectiveFactorRepository extends JpaRepository<InterpersonalAffectiveFactor, Long> {

    List<InterpersonalAffectiveFactor> getInterpersonalAffectiveFactorsByPatient_Id(Long id);
}
