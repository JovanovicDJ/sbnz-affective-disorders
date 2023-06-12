package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.service.dto.SymptomDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/symptom", produces = MediaType.APPLICATION_JSON_VALUE)
public class SymptomController {

    @PostMapping()
    public ResponseEntity<?> affectiveDisorderSymptoms(@RequestBody List<SymptomDTO> symptoms) {
        for (SymptomDTO s: symptoms) {
            System.out.println(s.getName());
            System.out.println(s.getIntensity());
            System.out.println("----------");
        }
        return ResponseEntity.status(HttpStatus.OK).body("HI!");
    }
}
