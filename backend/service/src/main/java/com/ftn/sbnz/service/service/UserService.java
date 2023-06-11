package com.ftn.sbnz.service.service;


import com.ftn.sbnz.model.Doctor;
import com.ftn.sbnz.service.dto.DoctorDTO;
import com.ftn.sbnz.service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByEmail(username);
        if (doctor == null) {
            throw new UsernameNotFoundException(String.format("No doctor found with email '%s'.", username));
        } else {
            return doctor;
        }
    }

    public Doctor findByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public Doctor save(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));

        return doctorRepository.save(doctor);
    }
}
