package com.mindlink.service.appointment.models.dtos.maps;

import com.mindlink.service.appointment.models.Appointment;
import com.mindlink.service.appointment.models.dtos.appointmentDTOs.AppointmentDTO;

public class AppointmentMapper {

    public static AppointmentDTO appointmentToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO(
                appointment.getId(),
                appointment.getPatient().getEmail(),
                appointment.getDoctor().getEmail(),
                appointment.getRoom().getRoomUrl(),
                appointment.getAppointmentDate(),
                appointment.getSessionType(),
                appointment.getTotalCost(),
                appointment.getRating(),
                appointment.getFeedback(),
                appointment.getCreatedAt(),
                appointment.getUpdatedAt(),
                appointment.getDeletedAt() != null);
        return dto;
    }
}
