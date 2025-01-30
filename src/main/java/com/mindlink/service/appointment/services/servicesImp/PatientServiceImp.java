/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.User;
import com.mindlink.service.appointment.models.dtos.PatientDTO;
import com.mindlink.service.appointment.models.dtos.UserDTO;
import com.mindlink.service.appointment.repositories.PatientRepository;
import com.mindlink.service.appointment.services.PatientService;
import com.mindlink.service.appointment.services.UserService;
import com.mindlink.service.appointment.utils.enums.UserRole;

import jakarta.transaction.Transactional;

/**
 *
 * @author madtore
 */
@Service
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserService userService;

    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstname(patientDTO.getFirstname());
        patient.setLastname(patientDTO.getLastname());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setGender(patientDTO.getGender());
        patient.setMedicalHistory(patientDTO.getMedicalHistory());
        patient.setCreatedAt(LocalDate.now());

        // Create associated user
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(patientDTO.getEmail());
        userDTO.setRole(UserRole.PATIENT);
        User user = userService.createUser(userDTO);
        patient.setUser(user);

        return patientRepository.save(patient);
    }

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(patient -> {
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setFirstname(patient.getFirstname());
            patientDTO.setLastname(patient.getLastname());
            patientDTO.setDateOfBirth(patient.getDateOfBirth());
            patientDTO.setGender(patient.getGender());
            patientDTO.setMedicalHistory(patient.getMedicalHistory());
            patientDTO.setEmail(patient.getUser().getEmail());
            return patientDTO;
        }).toList();
    }

    public Patient updatePatient(Long id, PatientDTO patientDTO) {
        Optional<Patient> existingPatient = patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            patient.setFirstname(patientDTO.getFirstname());
            patient.setLastname(patientDTO.getLastname());
            patient.setDateOfBirth(patientDTO.getDateOfBirth());
            patient.setGender(patientDTO.getGender());
            patient.setMedicalHistory(patientDTO.getMedicalHistory());
            patient.setUpdatedAt(LocalDate.now());
            return patientRepository.save(patient);
        }
        return null;
    }

    @Transactional
    public void deletePatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patient.get().setDeletedAt(LocalDate.now());
            patientRepository.save(patient.get());
        }
    }

    @Override
    public PatientDTO getPatientByEmail(String email) {
        PatientDTO patientDTO = patientRepository.findByUserEmail(email).map(
                patient -> {
                    PatientDTO dto = new PatientDTO();
                    dto.setFirstname(patient.getFirstname());
                    dto.setLastname(patient.getLastname());
                    dto.setDateOfBirth(patient.getDateOfBirth());
                    dto.setGender(patient.getGender());
                    dto.setMedicalHistory(patient.getMedicalHistory() != null ? patient.getMedicalHistory() : "");
                    dto.setEmail(patient.getUser().getEmail());
                    dto.setCreatedAt(patient.getCreatedAt());
                    dto.setUpdatedAt(patient.getUpdatedAt());
                    return dto;
                }).orElse(null);

        return patientDTO;
    }
}