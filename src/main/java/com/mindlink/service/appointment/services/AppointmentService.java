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

    AppointmentDTO createAppointment(AppointmentDTO appintmentDTO);

    List<AppointmentDTO> getAllAppointments();

    AppointmentDTO getAppointmentById(Long id);

    void deleteAppointment(Long id);

    AppointmentDTO updateAppointment(Long id, AppointmentDTO appintmentDTO);
}
