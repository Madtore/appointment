/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.List;
import java.util.Optional;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.dtos.AppointmentDTO;

/**
 *
 * @author madtore
 */
public interface AppointmentService {

    Appointment createAppointment(AppointmentDTO appointmentDTO);

    List<Appointment> getAllAppointments();

    Optional<Appointment> getAppointmentById(Long id);

    List<Appointment> getAppointmentsByPatient(Long patientId);

    List<Appointment> getAppointmentsByPsychologist(Long psychologistId);

    Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO);

    void deleteAppointment(Long id);
}
