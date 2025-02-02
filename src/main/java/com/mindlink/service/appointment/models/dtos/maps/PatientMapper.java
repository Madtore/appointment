package com.mindlink.service.appointment.models.dtos.maps;

import com.mindlink.service.appointment.models.Patient;
import com.mindlink.service.appointment.models.dtos.patientDTO.PatientDTO;

public class PatientMapper {

    public static PatientDTO patientToDTo(Patient patient) {
        return new PatientDTO(patient.getFirstName(), patient.getLastName(), patient.getEmail(),
                patient.getDateOfBirth(), patient.getGender());
    }

}
