package com.example.hotelmanage.controllers;


import com.example.hotelmanage.models.Room;
import com.example.hotelmanage.services.interfaces.RoomServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {
    private final RoomServiceInterface serv;

    public RoomController(RoomServiceInterface serv){
        this.serv=serv;
    }

    @GetMapping("/getAll")
    public List<Room> getAll(){
        return serv.getAll();
    }

    @PostMapping("/addRoom")
    public ResponseEntity<Room> create(@RequestBody Room room){
        Room createdRoom = serv.create(room);
        if(createdRoom == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED); //201
    }

}
