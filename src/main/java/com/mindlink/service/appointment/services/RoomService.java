/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.Optional;

import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.models.dtos.RoomDTO;

/**
 *
 * @author madtore
 */
public interface RoomService {

    Room createRoom(RoomDTO roomDTO);

    Optional<Room> getRoomByAppointmentId(Long appointmentId);

    Room updateRoom(Long id, RoomDTO roomDTO);

}
