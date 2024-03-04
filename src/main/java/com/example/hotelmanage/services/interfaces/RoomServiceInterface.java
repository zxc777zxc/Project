package com.example.hotelmanage.services.interfaces;

import com.example.hotelmanage.models.Room;

import java.util.List;

public interface RoomServiceInterface {
    List<Room> getAll();

    Room create(Room room);


}
