package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.Cyclothymia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CyclothymiaRepository extends JpaRepository<Cyclothymia, Long> {

    List<Cyclothymia> getCyclothymiasByPatient_Id(Long id);
}
