/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.List;

import com.mindlink.service.appointment.models.dtos.PsychologistDTO;

/**
 *
 * @author madtore
 */
public interface PsychologistService {

    PsychologistDTO getPsychologist(Long psychologistId);

    PsychologistDTO createPsychologist(PsychologistDTO psychologistDTO);

    PsychologistDTO updatePsychologist(Long psychologistId, PsychologistDTO psychologistDTO);

    void deletePsychologist(Long psychologistId);

    List<PsychologistDTO> getAllPsychologists();

}
