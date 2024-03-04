package com.example.hotelmanage.services;


import com.example.hotelmanage.models.Room;
import com.example.hotelmanage.repositories.RoomRepositoriesInterface;
import com.example.hotelmanage.services.interfaces.RoomServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements RoomServiceInterface{
    private final RoomRepositoriesInterface rep;

    public RoomService(RoomRepositoriesInterface rep) {
        this.rep = rep;
    }

    @Override
    public List<Room> getAll() {
        return rep.findAll();
    }

    @Override
    public Room create(Room room) {
        return rep.save(room);
    }


}
