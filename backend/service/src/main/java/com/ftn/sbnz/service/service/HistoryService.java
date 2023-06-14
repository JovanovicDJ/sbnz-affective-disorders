package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.dto.HistoryDTO;
import com.ftn.sbnz.service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private ManicEpisodeRepository manicEpisodeRepository;
    @Autowired
    private CyclothymiaRepository cyclothymiaRepository;
    @Autowired
    private DysthymiaRepository dysthymiaRepository;
    @Autowired
    private BipolarDisorderRepository bipolarDisorderRepository;
    @Autowired
    private RecurrentDepressiveDisorderRepository recDepressiveDisorderRepository;
    @Autowired
    private DepressiveEpisodeRepository depressiveEpisodeRepository;
    @Autowired
    private AffectiveFactorRepository affectiveFactorRepository;
    @Autowired
    private AntisocialFactorRepository antisocialFactorRepository;
    @Autowired
    private InterpersonalFactorRepository interpersonalFactorRepository;
    @Autowired
    private LifestyleFactorRepository lifestyleFactorRepository;
    @Autowired
    private InterpersonalAffectiveFactorRepository interpersonalAffectiveFactorRepository;
    @Autowired
    private SocialDevianceRepository socialDevianceRepository;
    @Autowired
    private PsychopathyRepository psychopathyRepository;


    public List<HistoryDTO> getPatientHistory(Long id) {
        List<HistoryDTO> history = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

        for (ManicEpisode me : manicEpisodeRepository.getManicEpisodesByPatient_Id(id)) {
            history.add(new HistoryDTO("Manična epizoda", dateFormat.format(me.getExecutionTime())));
        }
        for (DepressiveEpisode de : depressiveEpisodeRepository.getDepressiveEpisodesByPatient_Id(id)) {
            history.add(new HistoryDTO("Depresivna epizoda", dateFormat.format(de.getExecutionTime())));
        }
        for (BipolarDisorder bd : bipolarDisorderRepository.getBipolarDisordersByPatient_Id(id)) {
            history.add(new HistoryDTO("Bipolarni poremećaj", dateFormat.format(bd.getExecutionTime())));
        }
        for (RecurrentDepressiveDisorder rdd : recDepressiveDisorderRepository.getRecurrentDepressiveDisordersByPatient_Id(id)) {
            history.add(new HistoryDTO("Rekurentni bipolarni poremećaj", dateFormat.format(rdd.getExecutionTime())));
        }
        for (Cyclothymia c : cyclothymiaRepository.getCyclothymiasByPatient_Id(id)) {
            history.add(new HistoryDTO("Ciklotimija", c.getDate().format(formatter)));
        }
        for (Dysthymia d : dysthymiaRepository.getDysthymiasByPatient_Id(id)) {
            history.add(new HistoryDTO("Distimija", d.getDate().format(formatter)));
        }
        for (AffectiveFactor af : affectiveFactorRepository.getAffectiveFactorsByPatient_Id(id)) {
            history.add(new HistoryDTO("Afektivni faktor", af.getDate().format(formatter)));
        }
        for (AntisocialFactor af : antisocialFactorRepository.getAntisocialFactorsByPatient_Id(id)) {
            history.add(new HistoryDTO("Antisocijalni faktor", af.getDate().format(formatter)));
        }
        for (InterpersonalFactor ifa : interpersonalFactorRepository.getInterpersonalFactorsByPatient_Id(id)) {
            history.add(new HistoryDTO("Interpersonalni faktor", ifa.getDate().format(formatter)));
        }
        for (LifestyleFactor lf : lifestyleFactorRepository.getLifestyleFactorsByPatient_Id(id)) {
            history.add(new HistoryDTO("Faktor načina života", lf.getDate().format(formatter)));
        }
        for (InterpersonalAffectiveFactor iaf : interpersonalAffectiveFactorRepository.getInterpersonalAffectiveFactorsByPatient_Id(id)) {
            history.add(new HistoryDTO("Interpersonalni-afektivni faktor", iaf.getDate().format(formatter)));
        }
        for (SocialDeviance sd : socialDevianceRepository.getSocialDeviancesByPatient_Id(id)) {
            history.add(new HistoryDTO("Socijalna devijacija", sd.getDate().format(formatter)));
        }
        for (Psychopathy p : psychopathyRepository.getPsychopathiesByPatient_Id(id)) {
            history.add(new HistoryDTO("Psihopatija", p.getDate().format(formatter)));
        }

        return history;
    }
}
