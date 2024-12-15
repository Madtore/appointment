/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author madtore
 */
public record PatientDTO(
                @NotNull(message = "Patient ID cannot be null") Long id,

                @NotNull(message = "User ID cannot be null") Long userId,

                @NotNull(message = "Date of birth cannot be null") LocalDate dateOfBirth,

                @NotNull(message = "Gender cannot be null") String gender,

                @Size(max = 1000, message = "Medical history cannot exceed 1000 characters") String medicalHistory,

                LocalDate createdAt,
                LocalDate updatedAt,
                LocalDate deletedAt) {
}
