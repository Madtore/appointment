/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

package com.mindlink.service.appointment.utils.enums;

/**
 *
 * @author madtore
 */
public enum UserRole {
    PATIENT("Patient"),
    PSYCHOLOGIST("Psychologist"),
    ADMIN("Admin");

    private final String value;

    // Constructor
    UserRole(String value) {
        this.value = value;
    }

    // Getter para obtener el valor del enum como String
    public String getValue() {
        return value;
    }

    // Método estático para obtener el enum a partir de un valor String
    public static UserRole fromValue(String value) {
        for (UserRole type : UserRole.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}