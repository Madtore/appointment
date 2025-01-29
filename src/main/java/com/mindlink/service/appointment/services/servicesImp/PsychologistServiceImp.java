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

import com.mindlink.service.appointment.models.Psychologist;
import com.mindlink.service.appointment.models.User;
import com.mindlink.service.appointment.models.dtos.PsychologistDTO;
import com.mindlink.service.appointment.models.dtos.UserDTO;
import com.mindlink.service.appointment.repositories.PsychologistRepository;
import com.mindlink.service.appointment.services.PsychologistService;
import com.mindlink.service.appointment.services.UserService;
import com.mindlink.service.appointment.utils.enums.UserRole;

import jakarta.transaction.Transactional;

/**
 *
 * @author madtore
 */
@Service
public class PsychologistServiceImp implements PsychologistService {

    @Autowired
    private PsychologistRepository psychologistRepository;

    @Autowired
    private UserService userService;

    public Psychologist createPsychologist(PsychologistDTO psychologistDTO) {
        Psychologist psychologist = new Psychologist();
        psychologist.setUser(createUserForPsychologist(psychologistDTO));
        psychologist.setCreatedAt(LocalDate.now());

        return psychologistRepository.save(psychologist);
    }

    public User createUserForPsychologist(PsychologistDTO psychologistDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(psychologistDTO.getEmail());
        userDTO.setRole(UserRole.PSYCHOLOGIST);
        return userService.createUser(userDTO);
    }

    public List<Psychologist> getAllPsychologists() {
        return psychologistRepository.findAll();
    }

    public Optional<Psychologist> getPsychologistById(Long id) {
        return psychologistRepository.findById(id);
    }

    public Psychologist updatePsychologist(Long id, PsychologistDTO psychologistDTO) {
        Optional<Psychologist> existingPsychologist = psychologistRepository.findById(id);
        if (existingPsychologist.isPresent()) {
            Psychologist psychologist = existingPsychologist.get();
            psychologist.setUpdatedAt(LocalDate.now());
            return psychologistRepository.save(psychologist);
        }
        return null;
    }

    @Transactional
    public void deletePsychologist(Long id) {
        Optional<Psychologist> psychologist = psychologistRepository.findById(id);
        if (psychologist.isPresent()) {
            psychologist.get().setDeletedAt(LocalDate.now());
            psychologistRepository.save(psychologist.get());
        }
    }
}
