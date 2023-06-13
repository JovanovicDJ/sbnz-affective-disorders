package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.Doctor;
import com.ftn.sbnz.model.Patient;
import com.ftn.sbnz.service.dto.DoctorDTO;
import com.ftn.sbnz.service.dto.LoginDTO;
import com.ftn.sbnz.service.dto.PatientDTO;
import com.ftn.sbnz.service.service.PatientService;
import com.ftn.sbnz.service.service.UserService;
import com.ftn.sbnz.service.utils.Msg;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Doctor doctor = (Doctor) userService.loadUserByUsername(loginDTO.getEmail());
        Gson gson = new Gson();

        if (doctor != null && userService.isPasswordMatch(loginDTO.getPassword(), doctor.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(doctor);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(gson.toJson(new Msg("Neispravan e-mail ili lozinka!")));
        }
    }

    @PostMapping("register/patient")
    public ResponseEntity<?> registerPatient(@RequestBody PatientDTO patientDTO) {
        Gson gson = new Gson();

        Patient existingPatient = patientService.findByEmail(patientDTO.getEmail());

        if (existingPatient != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(gson.toJson(new Msg("E-mail je već upotrebljen!")));
        }

        Patient patient = patientService.save(patientDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @PostMapping("register/doctor")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        Gson gson = new Gson();

        Doctor existingDoctor = userService.findByEmail(doctorDTO.getEmail());

        if (existingDoctor != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(gson.toJson(new Msg("E-mail je već upotrebljen!")));
        }

        Doctor doctor = userService.save(doctorDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }
}
