package com.mindlink.service.appointment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.service.appointment.models.dtos.doctorDTO.DoctorDTO;
import com.mindlink.service.appointment.services.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping()
    public ResponseEntity<DoctorDTO> getPatientByEmail(@Valid @RequestParam String email) {
        try {
            DoctorDTO patient = doctorService.getDoctorByEmail(email);
            return ResponseEntity.ok(patient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
