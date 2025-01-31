
package com.mindlink.service.appointment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentDTO;
import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentRegistrationDTO;
import com.mindlink.service.appointment.services.AppointmentService;

import jakarta.validation.Valid;

/**
 *
 * @author madtore
 */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/patient")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentByPatientEmail(@Valid @RequestParam String patientEmail) {
        try {
            return ResponseEntity.ok(appointmentService.getAppointmentByPatientEmail(patientEmail));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentByDoctorEmail(@Valid @RequestParam String doctorEmail) {
        try {
            return ResponseEntity.ok(appointmentService.getAppointmentByDoctorEmail(doctorEmail));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> createAppointment(
            @RequestBody AppointmentRegistrationDTO appointmentDTO) {
        try {
            return ResponseEntity.ok(appointmentService.createAppointment(appointmentDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteAppointment(@Valid @RequestParam Long id) {
        try {
            appointmentService.deleteAppointment(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

/*
 * @Autowired
 * private AppointmentService appointmentService;
 * 
 * @PostMapping
 * public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody
 * AppointmentDTO appointmentDTO) {
 * try {
 * return
 * ResponseEntity.ok(appointmentService.createAppointment(appointmentDTO));
 * } catch (Exception e) {
 * return ResponseEntity.badRequest().build();
 * }
 * }
 * 
 * @GetMapping("/test")
 * public String getAppointment() {
 * return "Hello";
 * }
 * 
 * @GetMapping("/patient")
 * public ResponseEntity<List<AppointmentDTO>>
 * getAppointmentByEmailPatient(@RequestParam String patientEmail) {
 * try {
 * return
 * ResponseEntity.ok(appointmentService.getAppointmentByPatient(patientEmail));
 * } catch (Exception e) {
 * return ResponseEntity.badRequest().build();
 * }
 * }
 * 
 * @GetMapping("/psychologist")
 * public ResponseEntity<List<AppointmentDTO>>
 * getAppointmentByEmailPsychologist(
 * 
 * @RequestParam String psychologistEmail) {
 * try {
 * return ResponseEntity.ok(appointmentService.getAppointmentByPatient(
 * psychologistEmail));
 * } catch (Exception e) {
 * return ResponseEntity.badRequest().build();
 * }
 * }
 */
