/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.models.dtos.roomDTO.RoomDTO;

/**
 *
 * @author madtore
 */
public interface RoomService {

    Room createRoom(Appointment appointment);

    boolean isOpenJointToRoom(Long idAppointment);

    RoomDTO findByAppointmentId(Long appointmentID);

}
