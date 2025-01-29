package com.mindlink.service.appointment.models.dtos;

import com.mindlink.service.appointment.utils.enums.UserRole;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {

    private String email;
    private UserRole role;

}
