/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.service.appointment.models.dtos.PsychologistDTO;
import com.mindlink.service.appointment.services.PsychologistService;

/**
 *
 * @author madtore
 */
@RestController
@RequestMapping("/psychologists")
public class PsychologistController {

    @Autowired
    private PsychologistService psychologistService;

    @PostMapping
    public ResponseEntity<PsychologistDTO> createPsychologist(@RequestBody PsychologistDTO psychologistDTO) {
        try {
            return ResponseEntity.ok(psychologistService.createPsychologist(psychologistDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PsychologistDTO> getPsychologist(@RequestBody Long id) {
        try {
            return ResponseEntity.ok(psychologistService.getPsychologist(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePsychologist(@RequestBody Long id) {
        try {
            psychologistService.deletePsychologist(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
