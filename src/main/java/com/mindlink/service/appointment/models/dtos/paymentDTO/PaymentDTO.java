package com.mindlink.service.appointment.models.dtos.paymentDTO;

import java.time.LocalDate;

public record PaymentDTO(
                Double totalAmount,
                LocalDate createdAt) {
}
