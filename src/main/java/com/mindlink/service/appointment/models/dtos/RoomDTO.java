package com.mindlink.service.appointment.models.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RoomDTO {

    private String emailPatient;
    private String emailPsychologist;

    private String roomUrl;
    private String password;

}
