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

/**
 *
 * @author madtore
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appintmentDTO) throws Exception {
        Appointment appointment = new Appointment();
        appointment.setCreatedAt(LocalDate.now());
        appointment.setAppointmentDate(appintmentDTO.getAppointmentDate());
        appointment.set

        return null;
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentById'");
    }

    @Override
    public void deleteAppointment(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAppointment'");
    }

    @Override
    public void joinRoom(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'joinRoom'");
    }

}
