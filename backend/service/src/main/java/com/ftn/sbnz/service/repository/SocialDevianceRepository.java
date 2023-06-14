package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.SocialDeviance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialDevianceRepository extends JpaRepository<SocialDeviance, Long> {

    List<SocialDeviance> getSocialDeviancesByPatient_Id(Long id);
}
