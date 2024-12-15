/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import com.mindlink.service.appointment.models.dtos.RoomDTO;

/**
 *
 * @author madtore
 */
public interface RoomService {

    RoomDTO getRoomDetails(String roomId, String password);

    boolean verifyPassword(String roomId, Object password);

}
