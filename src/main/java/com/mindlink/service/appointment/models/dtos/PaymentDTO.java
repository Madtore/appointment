/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.mindlink.service.appointment.models.dtos;

/**
 *
 * @author madtore
 */
public record PaymentDTO(
        Long id,
        Long appointmentId,
        Double totalAmount) {

}
