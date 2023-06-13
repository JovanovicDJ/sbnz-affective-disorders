package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.ManicEpisode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManicEpisodeRepository extends JpaRepository<ManicEpisode, Long> {

    List<ManicEpisode> getManicEpisodesByPatient_Id(Long id);
}
