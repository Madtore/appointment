/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Psychologist;
import com.mindlink.service.appointment.models.User;
import com.mindlink.service.appointment.models.dtos.PsychologistDTO;
import com.mindlink.service.appointment.repositories.PsychologistRepository;
import com.mindlink.service.appointment.repositories.UserRepository;
import com.mindlink.service.appointment.services.PsychologistService;

/**
 *
 * @author madtore
 */
@Service
public class PsychologistServiceImpl implements PsychologistService {

    @Autowired
    private PsychologistRepository psychologistRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PsychologistDTO getPsychologist(Long psychologistId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPsychologist'");
    }

    @Override
    public PsychologistDTO createPsychologist(PsychologistDTO psychologistDTO) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPsychologist'");
    }

    @Override
    public void deletePsychologist(Long psychologistId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePsychologist'");
    }

}