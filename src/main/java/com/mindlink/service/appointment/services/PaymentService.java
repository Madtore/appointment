/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Payment;

/**
 *
 * @author madtore
 */
public interface PaymentService {

    Payment createPayment(Appointment appointment, double amount);

}
