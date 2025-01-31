package com.mindlink.service.appointment.models.dtos.appointmentDTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AppointmentDTO(
                Long id,
                String patientEmail,
                String doctorEmail,
                String room,
                LocalDateTime appointmentDate,
                Double totalCost,
                Integer rating,
                String feedback,
                LocalDate createdAt) {
}
