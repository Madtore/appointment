package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PsychologistDTO {

    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String gender;
    private String medicalHistory;

    private String email;

    private LocalDate createdAt;
    private LocalDate updatedAt;
}
