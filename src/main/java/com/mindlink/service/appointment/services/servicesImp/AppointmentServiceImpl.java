/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import com.mindlink.service.appointment.services.AppointmentService;

import com.mindlink.service.appointment.models.*;
import com.mindlink.service.appointment.models.dtos.*;
import com.mindlink.service.appointment.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setPsychologist(appointmentDTO.getEmailPsychologist());
        appointment.setPatient(appointmentDTO.getEmailPatient());
        appointment.setTotalCost(appointmentDTO.getTotalCost());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setCreatedAt(LocalDate.now());

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByPsychologist(Long psychologistId) {
        return appointmentRepository.findByPsychologistId(psychologistId);
    }

    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            appointment.setTotalCost(appointmentDTO.getTotalCost());
            appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
            appointment.setRating(appointmentDTO.getRating());
            appointment.setFeedback(appointmentDTO.getFeedback());
            appointment.setUpdatedAt(LocalDate.now());
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    @Transactional
    public void deleteAppointment(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointment.get().setDeletedAt(LocalDate.now());
            appointmentRepository.save(appointment.get());
        }
    }
}
