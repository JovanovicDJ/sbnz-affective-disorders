package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.dto.HistoryDTO;
import com.ftn.sbnz.service.dto.PatientDTO;
import com.ftn.sbnz.service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

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

    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public List<Patient> findByDoctorID(Long doctorID){
        return this.patientRepository.findByDoctorID(doctorID);
    }

    public Patient save(PatientDTO patientDTO) {
        Patient patient = new Patient();

        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setDob(patientDTO.getDob());
        patient.setGender(patientDTO.getGender());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhoneNum(patientDTO.getPhoneNum());
        patient.setDoctorID(patientDTO.getDoctorID());

        return patientRepository.save(patient);
    }

    public Patient findById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            return null;
        }
    }

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

        return history;
    }
}
