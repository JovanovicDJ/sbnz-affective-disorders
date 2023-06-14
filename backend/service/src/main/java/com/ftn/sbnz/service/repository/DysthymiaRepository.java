package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.Dysthymia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DysthymiaRepository extends JpaRepository<Dysthymia, Long> {

    List<Dysthymia> getDysthymiasByPatient_Id(Long id);
}
