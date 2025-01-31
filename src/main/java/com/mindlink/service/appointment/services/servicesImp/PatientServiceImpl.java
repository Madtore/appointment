/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.dtos.maps.PatientMaps;
import com.mindlink.service.appointment.models.dtos.patientDTO.PatientDTO;
import com.mindlink.service.appointment.repositories.PatientRepository;
import com.mindlink.service.appointment.services.PatientService;

/**
 *
 * @author madtore
 */
@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Optional<Patient> findByUserEmail(String email) {
        return patientRepository.findByUserEmail(email);

    }

    @Override
    public PatientDTO getPatientByEmail(String email) {
        Optional<Patient> patient = patientRepository.findByUserEmail(email);
        if (patient.isPresent()) {
            return PatientMaps.patientToDTo(patient.get());
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

}