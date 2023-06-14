package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.AntisocialFactor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AntisocialFactorRepository extends JpaRepository<AntisocialFactor, Long> {

    List<AntisocialFactor> getAntisocialFactorsByPatient_Id(Long id);
}
