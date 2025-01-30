/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.Payment;
import com.mindlink.service.appointment.models.Psychologist;
import com.mindlink.service.appointment.models.dtos.AppointmentDTO;
import com.mindlink.service.appointment.repositories.AppointmentRepository;
import com.mindlink.service.appointment.repositories.PatientRepository;
import com.mindlink.service.appointment.repositories.PsychologistRepository;
import com.mindlink.service.appointment.services.AppointmentService;
import com.mindlink.service.appointment.services.PaymentService;
import com.mindlink.service.appointment.services.RoomService;

/**
 * @autor MadTore
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PsychologistRepository psychologistRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Psychologist psychologist = psychologistRepository.findByUserEmail(appointmentDTO.getEmailPsychologist())
                .orElseThrow(() -> new RuntimeException("Psychologist not found"));

        Patient patient = patientRepository.findByUserEmail(appointmentDTO.getEmailPatient())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        // emailPatient
        appointment.setPatient(patient);
        // emailPsychologist
        appointment.setPsychologist(psychologist);

        // totalCost
        appointment.setTotalCost(appointmentDTO.getTotalCost());
        // rating
        appointment.setRating(0);
        // feedback
        appointment.setFeedback("");
        // roomUrl
        Payment payment = paymentService.createPayment(appointment, psychologist.getRatePerHour());
        appointment.setPayment(payment);
        appointment.setRoom(roomService.createRoom(appointment));

        try {
            appointmentRepository.save(appointment);
        } catch (Exception e) {
            throw new RuntimeException("Error creating appointment");
        }
        return appointmentDTO;
    }

    @Override
    public List<AppointmentDTO> getAppointmentByPatient(String patientEmail) {
        return appointmentRepository.getAppointmentByPatient(patientEmail)
                .orElse(Collections.emptyList())
                .stream()
                .map(
                        appointment -> {
                            AppointmentDTO dto = new AppointmentDTO();
                            dto.setEmailPatient(appointment.getPatient().getUser().getEmail());
                            dto.setEmailPsychologist(appointment.getPsychologist().getUser().getEmail());
                            dto.setTotalCost(appointment.getTotalCost());
                            dto.setAppointmentDate(appointment.getAppointmentDate());
                            dto.setRating(appointment.getRating());
                            dto.setFeedback(appointment.getFeedback());
                            dto.setRoomUrl(appointment.getRoom());
                            return dto;
                        })
                .toList();
    }

    @Override
    public List<AppointmentDTO> getAppointmentByPsycologist(String psychologistEmail) {
        return appointmentRepository.getAppointmentByPsycologist(psychologistEmail)
                .orElse(Collections.emptyList())
                .stream()
                .map(
                        appointment -> {
                            AppointmentDTO dto = new AppointmentDTO();
                            dto.setEmailPatient(appointment.getPatient().getUser().getEmail());
                            dto.setEmailPsychologist(appointment.getPsychologist().getUser().getEmail());
                            dto.setTotalCost(appointment.getTotalCost());
                            dto.setAppointmentDate(appointment.getAppointmentDate());
                            dto.setRating(appointment.getRating());
                            dto.setFeedback(appointment.getFeedback());
                            dto.setRoomUrl(appointment.getRoom());
                            return dto;
                        })
                .toList();
    }

}
