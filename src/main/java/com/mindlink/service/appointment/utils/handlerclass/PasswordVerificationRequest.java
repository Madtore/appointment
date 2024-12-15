package com.mindlink.service.appointment.utils.handlerclass;

public class PasswordVerificationRequest {

    private String password;

    public boolean verifyPassword(String password) {
        password = password.trim();
        return this.password.equals(password);
    }

    public Object getPassword() {
        return password;
    }
}
