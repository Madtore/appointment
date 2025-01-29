/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;
import java.util.Optional;

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
public class RoomServiceImp implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoomUrl(roomDTO.getRoomUrl());
        room.setCreatedAt(LocalDate.now());
        return roomRepository.save(room);
    }

    public Optional<Room> getRoomByAppointmentId(Long appointmentId) {
        return roomRepository.findByAppointmentId(appointmentId);
    }

    public Room updateRoom(Long id, RoomDTO roomDTO) {
        Optional<Room> existingRoom = roomRepository.findById(id);
        if (existingRoom.isPresent()) {
            Room room = existingRoom.get();
            room.setRoomUrl(roomDTO.getRoomUrl());
            room.setUpdatedAt(LocalDate.now());
            return roomRepository.save(room);
        }
        return null;
    }
}