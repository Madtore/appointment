/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mindlink.service.appointment.utils.enums.SessionType;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @NotNull
    private Double totalCost;
    @NotNull
    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    private SessionType sessionType;

    @Nullable
    private Integer rating;

    @Nullable
    private String feedback;

    @OneToOne(mappedBy = "appointment")
    private Room room;

    @OneToOne(mappedBy = "appointment")
    private Payment payment;

    @NotNull
    private LocalDate createdAt;
    @Nullable
    private LocalDate updatedAt;
    @Nullable
    private LocalDate deletedAt;

}
