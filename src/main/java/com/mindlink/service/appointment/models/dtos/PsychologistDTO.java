package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PsychologistDTO {

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String licenseNumber;
    @NotNull
    private String specialization;
    @NotNull
    private Double ratePerHour;

    @NotNull
    private String email;

    private LocalDate createdAt;
    private LocalDate updatedAt;
}
