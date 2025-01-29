/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import com.mindlink.service.appointment.models.dtos.PatientDTO;

/**
 *
 * @author madtore
 */
public interface PatientService {

    PatientDTO getPatientById(Long id) throws Exception;

    PatientDTO createPatient(PatientDTO patientDTO) throws Exception;

    PatientDTO updatePatient(Long id, PatientDTO patientDTO) throws Exception;

}
