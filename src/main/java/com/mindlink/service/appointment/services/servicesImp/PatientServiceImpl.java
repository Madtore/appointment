/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.dtos.PatientDTO;
import com.mindlink.service.appointment.services.PatientService;

/**
 *
 * @author madtore
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Override
    public List<PatientDTO> getAllPatients() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPatients'");
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPatientById'");
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPatient'");
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePatient'");
    }

    @Override
    public void deletePatient(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePatient'");
    }

}
