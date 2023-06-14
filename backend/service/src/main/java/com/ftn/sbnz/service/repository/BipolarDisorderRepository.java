package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.BipolarDisorder;
import com.ftn.sbnz.model.DepressiveEpisode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BipolarDisorderRepository extends JpaRepository<BipolarDisorder, Long> {
    List<BipolarDisorder> getBipolarDisordersByPatient_Id(Long id);
}
