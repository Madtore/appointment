package com.mindlink.service.appointment.models.dtos.maps;

import com.mindlink.service.appointment.models.Doctor;
import com.mindlink.service.appointment.models.dtos.doctorDTO.DoctorDTO;

public class DoctorMapper {

    public static DoctorDTO doctorToDTo(Doctor doctor) {
        return new DoctorDTO(doctor.getFirstName(), doctor.getLastName(), doctor.getEmail(), doctor.getDateOfBirth(),
                doctor.getGender(), doctor.getSpecialization(), doctor.getLicenseNumber(), doctor.getPriceHour());
    }

}
