/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.models.dtos.maps.RoomMapper;
import com.mindlink.service.appointment.models.dtos.roomDTO.RoomDTO;
import com.mindlink.service.appointment.repositories.RoomRepository;
import com.mindlink.service.appointment.services.RoomService;

import jakarta.transaction.Transactional;

/**
 *
 * @author madtore
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    @Override
    public Room createRoom(Appointment appointment) {
        Room room = new Room();
        room.setRoomUrl(UUID.randomUUID().toString().substring(0, 20));
        room.setAppointment(appointment);
        room.setCreatedAt(LocalDate.now());
        return roomRepository.save(room);
    }

    @Override
    public boolean isOpenJointToRoom(Long idAppointment) {
        Room room = roomRepository.findByAppointmentId(idAppointment)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentDateTime = room.getAppointment().getAppointmentDate();

        return now.isAfter(appointmentDateTime) && now.isBefore(appointmentDateTime.plusHours(1));
    }

    @Override
    public RoomDTO findByAppointmentId(Long appointmentID) {
        return roomRepository.findByAppointmentId(appointmentID).map(RoomMapper::roomToDTo)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

}