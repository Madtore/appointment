/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.List;

import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentDTO;
import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentRegistrationDTO;

/**
 *
 * @author madtore
 */
public interface AppointmentService {

    public List<AppointmentDTO> getAppointmentByPatientEmail(String email);

    public List<AppointmentDTO> getAppointmentByDoctorEmail(String email);

    public void deleteAppointment(Long id);

    public AppointmentRegistrationDTO createAppointment(AppointmentRegistrationDTO appointmentDTO);

}
