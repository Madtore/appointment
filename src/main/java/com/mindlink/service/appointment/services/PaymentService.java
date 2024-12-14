/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import com.mindlink.service.appointment.models.Payment;
import com.mindlink.service.appointment.models.dtos.PaymentDTO;

/**
 *
 * @author madtore
 */
public interface PaymentService {

    PaymentDTO createPayment(Payment payment);

    PaymentDTO updatePayment(Long id, Payment payment);

    void deletePayment(Long id);

    PaymentDTO getPaymentById(Long id);

}
