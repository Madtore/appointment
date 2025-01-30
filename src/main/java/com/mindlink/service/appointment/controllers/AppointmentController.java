
package com.mindlink.service.appointment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.service.appointment.models.dtos.AppointmentDTO;
import com.mindlink.service.appointment.services.AppointmentService;

/**
 *
 * @author madtore
 */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        try {
            return ResponseEntity.ok(appointmentService.createAppointment(appointmentDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/patient")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentByEmailPatient(@RequestBody String patientEmail) {
        try {
            return ResponseEntity.ok(appointmentService.getAppointmentByPatient(patientEmail));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/psychologist")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentByEmailPsychologist(
            @RequestBody String psychologistEmail) {
        try {
            return ResponseEntity.ok(appointmentService.getAppointmentByPatient(psychologistEmail));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}