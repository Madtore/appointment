/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 *
 * @author madtore
 */
public record PsychologistDTO(
        @NotNull(message = "Psychologist ID cannot be null") Long id,

        @NotNull(message = "License number cannot be null") String licenseNumber,

        @NotNull(message = "Specialization cannot be null") String specialization,

        @Positive(message = "Rate per hour must be positive") Double ratePerHour,

        LocalDate createdAt,
        LocalDate updatedAt,
        LocalDate deletedAt) {
}
