/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.dtos.PatientDTO;
import com.mindlink.service.appointment.repositories.PatientRepository;
import com.mindlink.service.appointment.repositories.UserRepository;
import com.mindlink.service.appointment.services.PatientService;

/**
 *
 * @author madtore
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PatientDTO getPatientById(Long id) throws Exception {
        Patient patient = patientRepository.findById(id).orElse(null);
        PatientDTO patientDTO = new PatientDTO(
                patient.getId(),
                patient.getUser().getId(),
                patient.getDateOfBirth(),
                patient.getGender(),
                patient.getMedicalHistory(),
                patient.getCreatedAt(),
                patient.getUpdatedAt(),
                patient.getDeletedAt());

        return patientDTO;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) throws Exception {
        Patient patient = new Patient();
        patient.setDateOfBirth(patientDTO.dateOfBirth());
        patient.setGender(patientDTO.gender());
        patient.setMedicalHistory(patientDTO.medicalHistory());
        patient.setUser(userRepository.findById(patientDTO.userId()).orElse(null));
        patient.setCreatedAt(patientDTO.createdAt());
        patient.setUpdatedAt(patientDTO.updatedAt());
        patient.setDeletedAt(patientDTO.deletedAt());
        patient = patientRepository.save(patient);

        return patientDTO;
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) throws Exception {
        Patient patient = patientRepository.findById(id).orElse(null);
        patient.setDateOfBirth(patientDTO.dateOfBirth());
        patient.setGender(patientDTO.gender());
        patient.setMedicalHistory(patientDTO.medicalHistory());
        patient.setUser(userRepository.findById(patientDTO.userId()).orElse(null));
        patient.setCreatedAt(patientDTO.createdAt());
        patient.setUpdatedAt(patientDTO.updatedAt());
        patient.setDeletedAt(patientDTO.deletedAt());
        patient = patientRepository.save(patient);

        return patientDTO;
    }

}
