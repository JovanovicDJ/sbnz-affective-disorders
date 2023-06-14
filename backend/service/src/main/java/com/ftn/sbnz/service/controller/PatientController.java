package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.Patient;
import com.ftn.sbnz.service.dto.HistoryDTO;
import com.ftn.sbnz.service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "api/patients/", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("forDoctor/{id}")
    public ResponseEntity<List<Patient>> getAll(@PathVariable Long id){
        List<Patient> ret = this.patientService.findByDoctorID(id);
        return ResponseEntity.ok(ret);
    }

    @GetMapping("history/{id}")
    public ResponseEntity<List<HistoryDTO>> getPatientHistory(@PathVariable Long id) {
        List<HistoryDTO> history = patientService.getPatientHistory(id);
        return ResponseEntity.status(HttpStatus.OK).body(history);
    }

}
