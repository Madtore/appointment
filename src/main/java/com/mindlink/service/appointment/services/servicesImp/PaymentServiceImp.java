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

import com.mindlink.service.appointment.models.Payment;
import com.mindlink.service.appointment.repositories.PaymentRepository;
import com.mindlink.service.appointment.services.PaymentService;

import jakarta.transaction.Transactional;

/**
 *
 * @author madtore
 */
@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        payment.setCreatedAt(LocalDate.now());
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getPaymentsByPatientId(Long patientId) {
        return paymentRepository.findByPatientId(patientId);
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);
        if (existingPayment.isPresent()) {
            Payment payment = existingPayment.get();
            payment.setTotalAmount(paymentDetails.getTotalAmount());
            payment.setUpdatedAt(LocalDate.now());
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Transactional
    public void deletePayment(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) {
            payment.get().setDeletedAt(LocalDate.now());
            paymentRepository.save(payment.get());
        }
    }
}