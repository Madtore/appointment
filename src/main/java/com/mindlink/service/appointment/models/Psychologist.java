/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author madtore
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Psychologist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Refers to Users.id

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String licenseNumber;
    @NotNull
    private String specialization;
    @NotNull
    private Double ratePerHour;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "psychologist")
    private List<Appointment> appointments;

    @NotNull
    private LocalDate createdAt;

    @Nullable
    private LocalDate updatedAt;
    @Nullable
    private LocalDate deletedAt;

    public Optional<Psychologist> stream() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stream'");
    }

}
