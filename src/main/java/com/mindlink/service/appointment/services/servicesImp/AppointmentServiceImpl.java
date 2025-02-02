/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.service.appointment.services.servicesImp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindlink.service.appointment.exceptions.AppontmentExeptions;
import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.Doctor;
import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.Payment;
import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentDTO;
import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentRegistrationDTO;
import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentUpdateDTO;
import com.mindlink.service.appointment.models.dtos.maps.AppointmentMapper;
import com.mindlink.service.appointment.repositories.AppointmentRepository;
import com.mindlink.service.appointment.services.AppointmentService;
import com.mindlink.service.appointment.services.DoctorService;
import com.mindlink.service.appointment.services.PatientService;
import com.mindlink.service.appointment.services.PaymentService;
import com.mindlink.service.appointment.services.RoomService;

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
                appointment.get().setDeletedAt(LocalDate.now());
                appointmentRepository.save(appointment.get());
            } else {
                throw new AppontmentExeptions("Appointment not found");
            }
        } catch (Exception e) {
            throw new AppontmentExeptions("Error deleting appointment");
        }
    }

    public AppointmentRegistrationDTO createAppointment(AppointmentRegistrationDTO appointmentDTO) {
        if (!isAppointmentHourValid(appointmentDTO.appointmentDate(), appointmentDTO.doctorEmail())) {
            throw new AppontmentExeptions("Appointment hour is not valid");
        }
        Doctor doctor = doctorService.findByUserEmail(appointmentDTO.doctorEmail())
                .orElseThrow(
                        () -> new AppontmentExeptions(
                                "Doctor with email " + appointmentDTO.doctorEmail() + " not found"));
        Patient patient = patientService.findByUserEmail(appointmentDTO.patientEmail())
                .orElseThrow(() -> new AppontmentExeptions(
                        "Patient with email " + appointmentDTO.patientEmail() + " not found"));

        Appointment appointment = buildAppointment(appointmentDTO, doctor, patient);
        appointment = appointmentRepository.save(appointment);

        Payment payment = paymentService.createPayment(appointment, doctor.getPriceHour());
        payment.setPatient(patient);
        appointment.setPayment(payment);
        Room room = roomService.createRoom(appointment);
        appointment.setRoom(room);

        appointment = appointmentRepository.save(appointment);
        return appointmentDTO;
    }

    @Override
    public List<AppointmentDTO> getAppointmentByPatientEmail(String email) {
        Optional<List<Appointment>> list = appointmentRepository.getAppointmentByPatient(email);

        return list.orElseThrow(() -> new AppontmentExeptions("Appointments not found"))
                .stream()
                .map(appointment -> {
                    return AppointmentMapper.appointmentToDTO(appointment);
                })
                .filter(appointment -> !appointment.isDeleted())
                .toList();
    }

    @Override
    public List<AppointmentDTO> getAppointmentByDoctorEmail(String email) {
        Optional<List<Appointment>> list = appointmentRepository.getAppointmentByDoctor(email);
        System.out.println(list.toString());
        return list.orElseThrow(() -> new AppontmentExeptions("Appointments not found"))
                .stream()
                .map(appointment -> {
                    return AppointmentMapper.appointmentToDTO(appointment);
                })
                .filter(appointment -> !appointment.isDeleted())
                .toList();
    }

    @Override
    public AppointmentDTO updateAppointment(AppointmentUpdateDTO appointmentDTO) {
        Optional<Appointment> appointment = Optional.ofNullable(appointmentRepository.findById(appointmentDTO.id())
                .orElseThrow(() -> new AppontmentExeptions("Appointment not found")));

        Optional.ofNullable(appointmentDTO.rating()).ifPresent(appointment.get()::setRating);
        Optional.ofNullable(appointmentDTO.feedback()).ifPresent(appointment.get()::setFeedback);
        Optional.ofNullable(appointmentDTO.appointmentDate()).ifPresent(appointment.get()::setAppointmentDate);

        appointment.get().setUpdatedAt(LocalDate.now());
        return AppointmentMapper.appointmentToDTO(appointmentRepository.save(appointment.get()));
    }

    private Appointment buildAppointment(AppointmentRegistrationDTO appointmentDTO, Doctor doctor, Patient patient) {
        return Appointment.builder()
                .appointmentDate(appointmentDTO.appointmentDate())
                .doctor(doctor)
                .sessionType(appointmentDTO.sessionType())
                .patient(patient)
                .totalCost(doctor.getPriceHour())
                .createdAt(LocalDate.now())
                .build();
    }

    private boolean isAppointmentHourValid(LocalDateTime appointementDateTime, String doctorEmail) {
        LocalDateTime appointmentTime = appointementDateTime;
        LocalDateTime now = LocalDateTime.now();
        if (appointmentTime.isBefore(now)) {
            return false;
        }
        List<AppointmentDTO> appointments = getAppointmentByDoctorEmail(doctorEmail);
        LocalDateTime oneHourBefore = appointmentTime.minusHours(1);
        LocalDateTime oneHourAfter = appointmentTime.plusHours(1);
        return !appointments.stream()
                .filter(appointmentDt -> {
                    return !appointmentDt.appointmentDate().isBefore(oneHourBefore) &&
                            !appointmentDt.appointmentDate().isAfter(oneHourAfter);
                })
                .findFirst()
                .isPresent();
    }

}
