package com.mindlink.service.appointment.models.dtos.patientDTO;

import java.time.LocalDate;

import com.mindlink.service.appointment.utils.enums.Gender;

public record PatientDTO(
        String firstName,
        String lastName,
        String email,
        LocalDate dateOfBirth,
        Gender gender) {

}
