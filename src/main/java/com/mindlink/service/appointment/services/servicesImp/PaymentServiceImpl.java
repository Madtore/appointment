/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Payment;
import com.mindlink.service.appointment.models.dtos.PaymentDTO;
import com.mindlink.service.appointment.services.PaymentService;

/**
 *
 * @author madtore
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentDTO createPayment(PaymentDTO payment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPayment'");
    }

    @Override
    public PaymentDTO updatePayment(Long id, Payment payment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePayment'");
    }

    @Override
    public void deletePayment(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePayment'");
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentById'");
    }

}
