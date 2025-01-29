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

import com.mindlink.service.appointment.models.User;
import com.mindlink.service.appointment.models.dtos.UserDTO;
import com.mindlink.service.appointment.repositories.UserRepository;
import com.mindlink.service.appointment.services.UserService;

import jakarta.transaction.Transactional;

/**
 *
 * @author madtore
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUserType(userDTO.getRole());
        user.setCreatedAt(LocalDate.now());
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setEmail(userDTO.getEmail());
            user.setUpdatedAt(LocalDate.now());
            return userRepository.save(user);
        }
        return null;
    }

    @Transactional
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setDeletedAt(LocalDate.now());
            userRepository.save(user.get());
        }
    }
}
