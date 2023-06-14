package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.InterpersonalFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterpersonalFactorRepository extends JpaRepository<InterpersonalFactor, Long> {

    List<InterpersonalFactor> getInterpersonalFactorsByPatient_Id(Long id);
}
