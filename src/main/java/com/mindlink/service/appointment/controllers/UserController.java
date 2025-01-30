
package com.mindlink.service.appointment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindlink.service.appointment.models.dtos.PatientDTO;
import com.mindlink.service.appointment.models.dtos.PsychologistDTO;
import com.mindlink.service.appointment.services.PatientService;
import com.mindlink.service.appointment.services.PsychologistService;
import com.mindlink.service.appointment.services.UserService;

/**
 *
 * @author madtore
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PsychologistService psychologistService;

    // GetMapping list all patients
    @GetMapping("/patients")
    public ResponseEntity<?> getAllPatients() {
        try {
            return ResponseEntity.ok(patientService.getAllPatients());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());

        }
    }

    // GetMapping for patients by email
    @GetMapping("/patients/email")
    public ResponseEntity<PatientDTO> getPatientsByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(patientService.getPatientByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // GetMapping for psychologists with pagination
    @GetMapping("/psychologists")
    public ResponseEntity<List<PsychologistDTO>> getAllPsychologists() {
        try {
            return ResponseEntity.ok(psychologistService.getAllPsychologists());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // GetMapping for psychologists by email
    @GetMapping("/psychologists/email")
    public ResponseEntity<PsychologistDTO> getPsychologistsByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(psychologistService.getPsychologistByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
