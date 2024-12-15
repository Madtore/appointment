/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import com.mindlink.service.appointment.models.dtos.PsychologistDTO;

/**
 *
 * @author madtore
 */
public interface PsychologistService {

    PsychologistDTO getPsychologist(Long psychologistId) throws Exception;

    PsychologistDTO createPsychologist(PsychologistDTO psychologistDTO) throws Exception;

    void deletePsychologist(Long psychologistId) throws Exception;

}
