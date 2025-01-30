/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.repositories.RoomRepository;
import com.mindlink.service.appointment.services.RoomService;

import jakarta.transaction.Transactional;

/**
 *
 * @author madtore
 */
@Service
public class RoomServiceImp implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    @Override
    public Room createRoom(Appointment appointment) {
        Room room = new Room();
        room.setAppointment(appointment);
        room.setCreatedAt(LocalDate.now());
        return roomRepository.save(room);
    }

}