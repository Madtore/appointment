/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.Psychologist;
import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.models.dtos.AppointmentDTO;
import com.mindlink.service.appointment.repositories.AppointmentRepository;
import com.mindlink.service.appointment.repositories.PatientRepository;
import com.mindlink.service.appointment.repositories.PsychologistRepository;
import com.mindlink.service.appointment.services.AppointmentService;

import jakarta.persistence.EntityNotFoundException;

/**
 *
 * @author madtore
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PsychologistRepository psychologistRepository;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        // Buscar entidades con manejo de Optional
        Psychologist psychologist = psychologistRepository.findById(appointmentDTO.psychologistId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Psychologist not found with id: " + appointmentDTO.psychologistId()));

        Patient patient = patientRepository.findById(appointmentDTO.patientId())
                .orElseThrow(
                        () -> new EntityNotFoundException("Patient not found with id: " + appointmentDTO.patientId()));

        // Crear la cita
        Appointment newAppointment = new Appointment();
        newAppointment.setPsychologist(psychologist);
        newAppointment.setPatient(patient);
        newAppointment.setTotalCost(appointmentDTO.totalCost());
        newAppointment.setAppointmentDate(appointmentDTO.appointmentDate());
        newAppointment.setCreatedAt(LocalDate.now()); // Usar LocalDateTime en lugar de LocalDate

        // Crear la sala
        Room room = new Room();
        room.setRoomUrl(UUID.randomUUID().toString());
        room.setPassword(UUID.randomUUID().toString());

        // Establecer relación bidireccional
        room.setAppointment(newAppointment);
        newAppointment.setRoom(room);

        // Guardar la cita (cascadeará el guardado de la sala si está configurado)
        Appointment savedAppointment = appointmentRepository.save(newAppointment);

        // Retornar un nuevo DTO con los datos actualizados
        return new AppointmentDTO(
                savedAppointment.getId(),
                savedAppointment.getPsychologist().getId(),
                savedAppointment.getPatient().getId(),
                savedAppointment.getTotalCost(),
                savedAppointment.getAppointmentDate(),
                null, // rating
                null, // feedback
                savedAppointment.getCreatedAt(),
                null, // updatedAt
                null // deletedAt
        );
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) throws Exception {
        Appointment appointment = appointmentRepository.findById(id).get();
        AppointmentDTO appointmentDTO = new AppointmentDTO(
                appointment.getId(), appointment.getPsychologist().getId(), appointment.getPatient().getId(),
                appointment.getTotalCost(), appointment.getAppointmentDate(),
                appointment.getRating(),
                appointment.getFeedback(),
                appointment.getCreatedAt(),
                appointment.getUpdatedAt(),
                appointment.getDeletedAt());

        return appointmentDTO;
    }

    @Override
    public void deleteAppointment(Long id) throws Exception {
        Appointment appointment = appointmentRepository.findById(id).get();
        appointment.setDeletedAt(LocalDate.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public void joinRoom(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'joinRoom'");
    }

}
