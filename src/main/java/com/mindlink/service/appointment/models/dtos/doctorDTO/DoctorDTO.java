package com.mindlink.service.appointment.models.dtos.doctorDTO;

import java.time.LocalDate;

import com.mindlink.service.appointment.utils.enums.Gender;

public record DoctorDTO(
                String firstName,
                String lastName,
                String email,
                LocalDate dateOfBirth,
                Gender gender,
                String specialization,
                String licenseNumber,
                Double priceHour) {
}
