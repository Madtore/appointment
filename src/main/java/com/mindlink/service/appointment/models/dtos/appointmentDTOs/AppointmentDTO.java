package com.mindlink.service.appointment.models.dtos.appointmentDTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mindlink.service.appointment.utils.enums.SessionType;

public record AppointmentDTO(
                Long id,
                String patientEmail,
                String doctorEmail,
                String room,
                LocalDateTime appointmentDate,
                SessionType sessionType,
                Double totalCost,
                Integer rating,
                String feedback,
                LocalDate createdAt,
                LocalDate updatedAt,
                boolean isDeleted) {
}
