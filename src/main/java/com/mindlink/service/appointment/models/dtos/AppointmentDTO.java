package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.Psychologist;
import com.mindlink.service.appointment.models.Room;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AppointmentDTO {

    @Email(message = "Email should be valid")
    private Psychologist emailPsychologist;
    @NotNull
    private Patient emailPatient;
    @NotNull
    private Double totalCost;
    @NotNull
    private LocalDate appointmentDate;
    @Nullable
    private Integer rating;
    @Nullable
    private String feedback;
    @Nullable
    private Room roomUrl;

}
