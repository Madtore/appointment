/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.models.dtos.RoomDTO;
import com.mindlink.service.appointment.repositories.RoomRepository;
import com.mindlink.service.appointment.services.RoomService;

/**
 *
 * @author madtore
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomDTO getRoomDetails(String roomId, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoomDetails'");
    }

    @Override
    public boolean verifyPassword(String roomId, Object password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyPassword'");
    }

}
