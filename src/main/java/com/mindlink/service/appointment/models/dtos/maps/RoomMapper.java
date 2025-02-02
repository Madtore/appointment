package com.mindlink.service.appointment.models.dtos.maps;

import com.mindlink.service.appointment.models.Room;
import com.mindlink.service.appointment.models.dtos.roomDTO.RoomDTO;

public class RoomMapper {

    public static RoomDTO roomToDTo(Room room) {
        return new RoomDTO("https://meet.jit.si/mindlink-appointment-" + room.getRoomUrl());
    }
}
