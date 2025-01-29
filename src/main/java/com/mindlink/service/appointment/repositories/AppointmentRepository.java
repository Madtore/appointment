/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.service.appointment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.dtos.AppointmentDTO;

/**
 *
 * @author madtore
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment create(AppointmentDTO appointmentDTO);

    List<Appointment> findAll();

    Optional<Appointment> findById(Long id);

    void deleteById(Long id);

}
