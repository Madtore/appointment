/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.User;
import com.mindlink.service.appointment.services.UserService;

/**
 *
 * @author madtore
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService userService;

    @Override
    public User create(User user) {
        return userService.create(user);
    }

}
