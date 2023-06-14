package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.LifestyleFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LifestyleFactorRepository extends JpaRepository<LifestyleFactor, Long> {

    List<LifestyleFactor> getLifestyleFactorsByPatient_Id(Long id);
}
