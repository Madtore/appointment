/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.dtos.AppointmentDTO;
import com.mindlink.service.appointment.services.AppointmentService;

/**
 *
 * @author madtore
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appintmentDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAppointment'");
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAppointments'");
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentById'");
    }

    @Override
    public void deleteAppointment(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAppointment'");
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appintmentDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAppointment'");
    }

}
