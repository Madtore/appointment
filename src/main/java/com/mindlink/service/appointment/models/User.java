/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.models;

import java.time.LocalDate;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.mindlink.service.appointment.utils.enums.UserRole;

import io.micrometer.common.lang.Nullable;

/**
 *
 * @author madtore
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private UserRole userType;

    @OneToOne(mappedBy = "user", targetEntity = Psychologist.class, cascade = CascadeType.ALL)
    private Psychologist psychologist;

    @OneToOne(mappedBy = "user", targetEntity = Psychologist.class, cascade = CascadeType.ALL)
    private Patient patient;

    @NotNull
    private LocalDate createdAt;
    @Nullable
    private LocalDate updatedAt;
    @Nullable
    private LocalDate deletedAt;
}
