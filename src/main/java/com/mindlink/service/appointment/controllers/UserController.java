
package com.mindlink.service.appointment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindlink.service.appointment.models.dtos.PatientDTO;
import com.mindlink.service.appointment.services.PatientService;
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

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDTO>> getPatients() {
        try {
            return ResponseEntity.ok(patientService.getAllPatients());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
