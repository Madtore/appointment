/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Payment;
import com.mindlink.service.appointment.repositories.PaymentRepository;
import com.mindlink.service.appointment.services.PaymentService;

import jakarta.transaction.Transactional;

/**
 *
 * @author madtore
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    @Override
    public Payment createPayment(Appointment appointment, double amount) {
        Payment payment = new Payment();
        payment.setPatient(appointment.getPatient());
        payment.setAppointment(appointment);
        payment.setTotalAmount(amount);
        payment.setCreatedAt(LocalDate.now());
        return paymentRepository.save(payment);
    }

}