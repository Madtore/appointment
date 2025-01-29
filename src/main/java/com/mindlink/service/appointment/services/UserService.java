/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.services;

import java.util.List;
import java.util.Optional;

import com.mindlink.service.appointment.models.User;
import com.mindlink.service.appointment.models.dtos.UserDTO;

/**
 *
 * @author madtore
 */
public interface UserService {

    User createUser(UserDTO userDTO);

    Optional<User> getUserById(Long id);

    public Optional<User> getUserByEmail(String email);

    public List<User> getAllUsers();

    User updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

}
