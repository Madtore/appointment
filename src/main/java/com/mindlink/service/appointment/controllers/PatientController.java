package com.mindlink.service.appointment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.service.appointment.models.dtos.patientDTO.PatientDTO;
import com.mindlink.service.appointment.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<PatientDTO> getPatientByEmail(@Valid @RequestParam String email) {
        try {
            PatientDTO patient = patientService.getPatientByEmail(email);
            return ResponseEntity.ok(patient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
