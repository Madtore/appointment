/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.List;

import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.dtos.PatientDTO;

/**
 *
 * @author madtore
 */
public interface PatientService {

    Patient createPatient(PatientDTO patientDTO);

    List<PatientDTO> getAllPatients();

    Patient updatePatient(Long id, PatientDTO patientDTO);

    PatientDTO getPatientByEmail(String email);

    void deletePatient(Long id);
}
