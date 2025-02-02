package com.mindlink.service.appointment.exceptions;

public class AppontmentExeptions extends RuntimeException {
    public AppontmentExeptions(String message) {
        super(message);
    }

    public AppontmentExeptions(String message, Throwable cause) {
        super(message, cause);
    }
}
