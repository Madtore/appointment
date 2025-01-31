package com.mindlink.service.appointment.services;

import java.util.Optional;

import com.mindlink.service.appointment.models.Doctor;
import com.mindlink.service.appointment.models.dtos.doctorDTO.DoctorDTO;

public interface DoctorService {
    Optional<Doctor> findByUserEmail(String email);

    DoctorDTO getDoctorByEmail(String email);

}
