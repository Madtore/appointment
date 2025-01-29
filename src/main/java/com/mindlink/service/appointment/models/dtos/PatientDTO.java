package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PatientDTO {

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private String gender;
    private String medicalHistory;

    private String email;

    private LocalDate createdAt;
    private LocalDate updatedAt;

}
