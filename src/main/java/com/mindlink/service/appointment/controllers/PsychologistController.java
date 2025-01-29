
package com.mindlink.service.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PsychologistDTO> getPsychologist(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePsychologist(@PathVariable Long id) {
        return null;
    }
}
