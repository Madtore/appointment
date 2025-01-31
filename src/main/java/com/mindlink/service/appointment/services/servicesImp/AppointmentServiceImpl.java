/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Doctor;
import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.Payment;
import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentDTO;
import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentRegistrationDTO;
import com.mindlink.service.appointment.models.dtos.maps.AppointmentMaps;
import com.mindlink.service.appointment.repositories.AppointmentRepository;
import com.mindlink.service.appointment.services.AppointmentService;
import com.mindlink.service.appointment.services.DoctorService;
import com.mindlink.service.appointment.services.PatientService;
import com.mindlink.service.appointment.services.PaymentService;
import com.mindlink.service.appointment.services.RoomService;

import jakarta.transaction.Transactional;

/**
 * @autor MadTore
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;
    private DoctorService doctorService;
    private PatientService patientService;
    private PaymentService paymentService;
    private RoomService roomService;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
            PatientService patientService,
            DoctorService doctorService,
            PaymentService paymentService,
            RoomService roomService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.paymentService = paymentService;
        this.roomService = roomService;
    }

    @Override
    public void deleteAppointment(Long id) {
        try {
            Optional<Appointment> appointment = appointmentRepository.findById(id);
            if (appointment.isPresent()) {
                appointmentRepository.delete(appointment.get());
            } else {
                throw new RuntimeException("Appointment not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting appointment");
        }
    }

    public AppointmentRegistrationDTO createAppointment(AppointmentRegistrationDTO appointmentDTO) {
        // Trova il dottore e il paziente
        Doctor doctor = doctorService.findByUserEmail(appointmentDTO.doctorEmail())
                .orElseThrow(
                        () -> new RuntimeException("Doctor with email " + appointmentDTO.doctorEmail() + " not found"));
        Patient patient = patientService.findByUserEmail(appointmentDTO.patientEmail())
                .orElseThrow(() -> new RuntimeException(
                        "Patient with email " + appointmentDTO.patientEmail() + " not found"));

        // Crea l'appuntamento
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDTO.appointmentDate());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setTotalCost(appointmentDTO.totalCost());

        // Imposta la data di creazione
        appointment.setCreatedAt(LocalDate.now()); // Assicurati che la data venga impostata correttamente

        // Salva l'appuntamento
        appointment = appointmentRepository.save(appointment);

        // Crea il pagamento e imposta il paziente nel pagamento
        Payment payment = paymentService.createPayment(appointment, doctor.getPriceHour());
        payment.setPatient(patient); // Imposta il paziente nel pagamento

        if (payment == null) {
            throw new RuntimeException("Payment creation failed for appointment");
        }

        appointment.setPayment(payment);

        // Crea la stanza
        Room room = roomService.createRoom(appointment);
        if (room == null) {
            throw new RuntimeException("Room creation failed for appointment");
        }
        appointment.setRoom(room);

        // Salva nuovamente l'appuntamento con il pagamento e la stanza
        appointment = appointmentRepository.save(appointment);

        return appointmentDTO;
    }

    @Override
    public List<AppointmentDTO> getAppointmentByPatientEmail(String email) {
        Optional<List<Appointment>> list = appointmentRepository.getAppointmentByPatient(email);
        return list.orElseThrow(() -> new RuntimeException("Appointments not found"))
                .stream()
                .map(appointment -> {
                    return AppointmentMaps.AppointmentToDTO(appointment);
                })
                .toList();
    }

    @Override
    public List<AppointmentDTO> getAppointmentByDoctorEmail(String email) {
        Optional<List<Appointment>> list = appointmentRepository.getAppointmentByDoctor(email);
        return list.orElseThrow(() -> new RuntimeException("Appointments not found"))
                .stream()
                .map(appointment -> {
                    return AppointmentMaps.AppointmentToDTO(appointment);
                })
                .toList();
    }

}
