/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.mindlink.service.appointment.models.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author madtore
 */

public class PatientDTO {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;

    @NotNull(message = "Gender cannot be null")
    private String gender;

    @Size(max = 1000, message = "Medical history cannot exceed 1000 characters")
    private String medicalHistory;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate deletedAt;

    public PatientDTO() {
    }

    public PatientDTO(@NotNull(message = "Patient ID cannot be null") Long id,
            @NotNull(message = "User ID cannot be null") Long userId,
            @NotNull(message = "Date of birth cannot be null") LocalDate dateOfBirth,
            @NotNull(message = "Gender cannot be null") String gender,
            @Size(max = 1000, message = "Medical history cannot exceed 1000 characters") String medicalHistory,
            LocalDate createdAt, LocalDate updatedAt, LocalDate deletedAt) {

        this.userId = userId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.medicalHistory = medicalHistory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeletedAt(LocalDate deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

}
