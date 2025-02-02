package com.mindlink.service.appointment.models.dtos.appointmentDTOs;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record AppointmentUpdateDTO(
                @NotNull Long id,
                Integer rating,
                String feedback,
                LocalDateTime appointmentDate) {

}
