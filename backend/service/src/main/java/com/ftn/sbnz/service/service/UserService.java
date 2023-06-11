package com.ftn.sbnz.service.service;


import com.ftn.sbnz.model.Doctor;
import com.ftn.sbnz.service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByEmail(username);
        if (doctor == null) {
            throw new UsernameNotFoundException(String.format("No doctor found with email '%s'.", username));
        } else {
            return doctor;
        }
    }
}
