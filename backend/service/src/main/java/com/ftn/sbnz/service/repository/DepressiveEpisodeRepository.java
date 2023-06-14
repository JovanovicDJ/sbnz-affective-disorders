package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.DepressiveEpisode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepressiveEpisodeRepository extends JpaRepository<DepressiveEpisode, Long> {

    List<DepressiveEpisode> getDepressiveEpisodesByPatient_Id(Long id);

}
