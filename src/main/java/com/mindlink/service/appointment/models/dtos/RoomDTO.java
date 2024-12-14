/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.mindlink.service.appointment.models.dtos;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author madtore
 */
public record RoomDTO(
        @NotNull(message = "Room ID cannot be null") Long id,

        @NotNull(message = "Room ID cannot be null") String roomId,

        @NotNull(message = "Room URL cannot be null") String roomUrl,

        @NotNull(message = "Password cannot be null") String password) {
}