/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Doctor;
import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.dtos.doctorDTO.DoctorDTO;
import com.mindlink.service.appointment.models.dtos.doctorDTO.DoctorRegistrationRequest;
import com.mindlink.service.appointment.models.dtos.maps.DoctorMapper;
import com.mindlink.service.appointment.models.dtos.maps.PatientMapper;
import com.mindlink.service.appointment.models.dtos.patientDTO.PatientDTO;
import com.mindlink.service.appointment.models.dtos.patientDTO.PatientRegistrationRequest;
import com.mindlink.service.appointment.repositories.UserRepository;
import com.mindlink.service.appointment.services.UserService;

/**
 *
 * @author madtore
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PatientDTO createPatient(PatientRegistrationRequest request) {

        Patient patient = new Patient(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                request.getDateOfBirth(),
                request.getGender());

        userRepository.save(patient);
        return PatientMapper.patientToDTo(patient);
    }

    @Override
    public DoctorDTO createDoctor(DoctorRegistrationRequest request) {

        Doctor doctor = new Doctor(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                request.getDateOfBirth(),
                request.getGender(),
                request.getSpecialization(),
                request.getLicenseNumber(),
                request.priceHour());

        userRepository.save(doctor);
        return DoctorMapper.doctorToDTo(doctor);
    }
}
