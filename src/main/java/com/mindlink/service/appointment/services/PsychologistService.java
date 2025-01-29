/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.List;
import java.util.Optional;

import com.mindlink.service.appointment.models.Psychologist;
import com.mindlink.service.appointment.models.User;
import com.mindlink.service.appointment.models.dtos.PsychologistDTO;

/**
 *
 * @author madtore
 */
public interface PsychologistService {

    Psychologist createPsychologist(PsychologistDTO psychologistDTO);

    User createUserForPsychologist(PsychologistDTO psychologistDTO);

    List<Psychologist> getAllPsychologists();

    Optional<Psychologist> getPsychologistById(Long id);

    Psychologist updatePsychologist(Long id, PsychologistDTO psychologistDTO);

    void deletePsychologist(Long id);

}
