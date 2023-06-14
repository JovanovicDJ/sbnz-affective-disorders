package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.RecurrentDepressiveDisorder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecurrentDepressiveDisorderRepository extends JpaRepository<RecurrentDepressiveDisorder, Long> {

    List<RecurrentDepressiveDisorder> getRecurrentDepressiveDisordersByPatient_Id(Long id);
}
