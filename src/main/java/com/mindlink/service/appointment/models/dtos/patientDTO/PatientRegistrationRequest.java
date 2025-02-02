package com.mindlink.service.appointment.models.dtos.patientDTO;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import com.mindlink.service.appointment.utils.enums.Gender;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public record PatientRegistrationRequest(
        @NotBlank @Getter String firstName,

        @NotBlank @Getter String lastName,

        @Email @NotBlank @Getter String email,

        @Size(min = 8) @NotBlank @Getter String password,

        @Past @Getter LocalDate dateOfBirth,

        @Getter @Enumerated Gender gender) {

}
