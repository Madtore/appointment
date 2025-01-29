/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.Optional;

import com.mindlink.service.appointment.models.Payment;

/**
 *
 * @author madtore
 */
public interface PaymentService {

    Payment createPayment(Payment payment);

    Optional<Payment> getPaymentById(Long id);

    Payment updatePayment(Long id, Payment paymentDetails);

    void deletePayment(Long id);

}
