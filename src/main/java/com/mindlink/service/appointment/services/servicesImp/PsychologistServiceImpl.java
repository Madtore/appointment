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
        Psychologist psychologist = psychologistRepository.findById(psychologistId)
                .orElseThrow(() -> new Exception("Psychologist not found"));

        PsychologistDTO psychologistDTO = new PsychologistDTO(
                psychologist.getId(),
                psychologist.getUser().getId(),
                psychologist.getLicenseNumber(),
                psychologist.getSpecialization(),
                psychologist.getRatePerHour(),
                psychologist.getCreatedAt(),
                psychologist.getUpdatedAt(),
                psychologist.getDeletedAt());

        return psychologistDTO;
    }

    @Override
    public PsychologistDTO createPsychologist(PsychologistDTO psychologistDTO) {
        Psychologist psychologist = new Psychologist();

        psychologist.setLicenseNumber(psychologistDTO.licenseNumber());
        psychologist.setSpecialization(psychologistDTO.specialization());
        psychologist.setRatePerHour(psychologistDTO.ratePerHour());
        User user = userRepository.findById(psychologistDTO.userId()).orElse(null);
        psychologist.setUser(user);
        psychologist.setCreatedAt(LocalDate.now());
        psychologist.setUpdatedAt(null);
        psychologist.setDeletedAt(null);
        psychologistRepository.save(psychologist);

        return psychologistDTO;
    }

    @Override
    public void deletePsychologist(Long psychologistId) {
        Psychologist psychologist = psychologistRepository.findById(psychologistId).orElse(null);
        psychologist.setDeletedAt(LocalDate.now());
        psychologistRepository.save(psychologist);
    }

}
