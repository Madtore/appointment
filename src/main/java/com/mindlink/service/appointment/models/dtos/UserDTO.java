/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import com.mindlink.service.appointment.utils.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author madtore
 */
public record UserDTO(
        @NotNull(message = "User ID cannot be null") Long id,

        @NotNull(message = "Username cannot be null") @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters") String username,

        @NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,

        @NotNull(message = "Password cannot be null") String passwordHash,

        LocalDate createdAt,
        LocalDate updatedAt,
        LocalDate deletedAt,

        @NotNull(message = "User type cannot be null") UserRole userType // Assuming you have the UserType enum defined
) {
}
