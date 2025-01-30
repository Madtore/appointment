/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.List;

import com.mindlink.service.appointment.models.dtos.AppointmentDTO;

/**
 *
 * @author madtore
 */
public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> getAppointmentByPatient(String patientEmail);

    List<AppointmentDTO> getAppointmentByPsycologist(String patientEmail);
}
