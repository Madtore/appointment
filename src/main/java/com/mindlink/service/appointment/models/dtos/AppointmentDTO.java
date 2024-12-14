/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 *
 * @author madtore
 */
public record AppointmentDTO(
                @NotNull(message = "Appointment ID cannot be null") Long id,

                @NotNull(message = "Psychologist ID cannot be null") Long psychologistId,

                @NotNull(message = "Patient ID cannot be null") Long patientId,

                @Positive(message = "Total cost must be positive") Double totalCost,

                @NotNull(message = "Appointment date cannot be null") @Future(message = "Appointment date must be in the future") LocalDate appointmentDate,

                @Min(value = 1, message = "Rating must be between 1 and 5") @Max(value = 5, message = "Rating must be between 1 and 5") Integer rating,

                @Size(max = 500, message = "Feedback cannot exceed 500 characters") String feedback,

                LocalDate createdAt,
                LocalDate updatedAt,
                LocalDate deletedAt) {
}