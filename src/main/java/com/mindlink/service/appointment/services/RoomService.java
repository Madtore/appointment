/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.List;

import com.mindlink.service.appointment.models.dtos.RoomDTO;

/**
 *
 * @author madtore
 */
public interface RoomService {

    RoomDTO createRoom(RoomDTO roomDTO);

    RoomDTO updateRoom(Long id, RoomDTO roomDTO);

    void deleteRoom(Long id);

    RoomDTO getRoomById(Long id);

    List<RoomDTO> getAllRooms();

}
