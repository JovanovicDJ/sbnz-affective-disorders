package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.Symptom;
import com.ftn.sbnz.service.dto.SymptomDTO;
import com.ftn.sbnz.service.service.AffectiveDisordersService;
import com.ftn.sbnz.service.service.PsychopathyService;
import com.ftn.sbnz.service.utils.Msg;
import com.ftn.sbnz.service.utils.SymptomEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/symptom", produces = MediaType.APPLICATION_JSON_VALUE)
public class SymptomController {

    @Autowired
    private AffectiveDisordersService affectiveDisordersService;

    @Autowired
    private PsychopathyService psychopathyService;

    @PostMapping()
    public ResponseEntity<?> affectiveDisorderSymptoms(@RequestBody List<SymptomDTO> symptomsDTO) {
        List<Symptom> symptoms = new ArrayList<>();
        SymptomEncoder encoder = new SymptomEncoder();
        for (SymptomDTO s: symptomsDTO) {
            Symptom symptom = new Symptom(s.getName(), s.getIntensity(), encoder.getSymptomGroup(s.getName()), Math.toIntExact(s.getPatientId()));
            symptoms.add(symptom);
        }
        String disorder = affectiveDisordersService.findAffectiveDisorders(symptoms);

        return ResponseEntity.status(HttpStatus.OK).body(new Msg(disorder));
    }


    @PostMapping("/psycho")
    public ResponseEntity<?> PsychopathySymptoms(@RequestBody List<SymptomDTO> symptomsDTO) {
        List<Symptom> symptoms = new ArrayList<>();
        SymptomEncoder encoder = new SymptomEncoder();
        for (SymptomDTO s: symptomsDTO) {
            Symptom symptom = new Symptom(s.getName(), s.getIntensity(), encoder.getSymptomGroup(s.getName()), Math.toIntExact(s.getPatientId()));
            symptoms.add(symptom);
        }
        String disorder = psychopathyService.findPsychopathyDisorder(symptoms);

        return ResponseEntity.status(HttpStatus.OK).body(new Msg(disorder));
    }
}
