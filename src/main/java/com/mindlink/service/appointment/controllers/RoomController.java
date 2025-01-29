
package com.mindlink.service.appointment.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return null;
    }

    @MessageMapping("/join")
    @SendTo("/topic/room")
    public Map<String, Object> joinRoom(Map<String, Object> message) {
        return Map.of(
                "type", "USER_JOINED",
                "userId", message.get("userId"),
                "roomId", message.get("roomId"));
    }

    @MessageMapping("/offer")
    @SendTo("/topic/room")
    public Map<String, Object> handleOffer(Map<String, Object> message) {
        return Map.of(
                "type", "OFFER",
                "offer", message.get("offer"),
                "userId", message.get("userId"),
                "targetUserId", message.get("targetUserId"));
    }

    @MessageMapping("/answer")
    @SendTo("/topic/room")
    public Map<String, Object> handleAnswer(Map<String, Object> message) {
        return Map.of(
                "type", "ANSWER",
                "answer", message.get("answer"),
                "userId", message.get("userId"),
                "targetUserId", message.get("targetUserId"));
    }

    @MessageMapping("/ice-candidate")
    @SendTo("/topic/room")
    public Map<String, Object> handleIceCandidate(Map<String, Object> message) {
        return Map.of(
                "type", "ICE_CANDIDATE",
                "candidate", message.get("candidate"),
                "userId", message.get("userId"),
                "targetUserId", message.get("targetUserId"));
    }
}
