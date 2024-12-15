/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import com.mindlink.service.appointment.models.dtos.AppointmentDTO;

/**
 *
 * @author madtore
 */
public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO appintmentDTO) throws Exception;

    AppointmentDTO getAppointmentById(Long id) throws Exception;

    void deleteAppointment(Long id) throws Exception;

    void joinRoom(Long id) throws Exception;
}
