/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import com.mindlink.service.appointment.models.dtos.doctorDTO.DoctorDTO;
import com.mindlink.service.appointment.models.dtos.doctorDTO.DoctorRegistrationRequest;
import com.mindlink.service.appointment.models.dtos.patientDTO.PatientDTO;
import com.mindlink.service.appointment.models.dtos.patientDTO.PatientRegistrationRequest;

/**
 *
 * @author madtore
 */

public interface UserService {

    DoctorDTO createDoctor(DoctorRegistrationRequest request);

    PatientDTO createPatient(PatientRegistrationRequest request);
}
