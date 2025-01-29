
package com.mindlink.service.appointment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.service.appointment.models.dtos.PatientDTO;
import com.mindlink.service.appointment.services.PatientService;

/**
 *
 * @author madtore
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable Long id) {
        return null;

    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(
            @PathVariable Long id,
            @RequestBody PatientDTO patientDTO) {
        return null;
    }
}
