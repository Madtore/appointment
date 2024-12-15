/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.service.appointment.models.dtos.RoomDTO;
import com.mindlink.service.appointment.services.RoomService;
import com.mindlink.service.appointment.utils.handlerclass.PasswordVerificationRequest;

/**
 *
 * @author madtore
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/{roomId}/verify")
    public ResponseEntity<Boolean> verifyRoomPassword(
            @PathVariable String roomId,
            @RequestBody PasswordVerificationRequest request) {
        boolean isValid = roomService.verifyPassword(roomId, request.getPassword());
        return ResponseEntity.ok(isValid);
    }

    @GetMapping("/{roomId}/join")
    public ResponseEntity<RoomDTO> joinRoom(
            @PathVariable String roomId,
            @RequestParam String password) {
        RoomDTO details = roomService.getRoomDetails(roomId, password);
        return ResponseEntity.ok(details);
    }
}
