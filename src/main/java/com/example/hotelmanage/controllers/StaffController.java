package com.example.hotelmanage.controllers;


import com.example.hotelmanage.models.Staff;
import com.example.hotelmanage.services.interfaces.StaffServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {
    private final StaffServiceInterface serv;

    public StaffController(StaffServiceInterface serv) {
        this.serv = serv;
    }

    @GetMapping("/getAll")
    public List<Staff> getAll(){
        return serv.getAll();
    }

    @GetMapping("/{StaffID}")
    public ResponseEntity<Staff> getById(@PathVariable("StaffID") int id){
        Staff staff = serv.getById(id);
        if(staff == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @PostMapping("addStaff")
    public ResponseEntity<Staff> create(@RequestBody Staff staff){
        Staff createdStaff = serv.create(staff);
        if(createdStaff == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdStaff, HttpStatus.CREATED); //201
    }

    @GetMapping("/name/{StaffName}")
    public List<Staff> getAllByName(@PathVariable("StaffName") String name){
        return serv.getByName(name);
    }

    @GetMapping("/pos/{Position}")
    public List<Staff> getAllByPosition(@PathVariable("Position") String position){
        return serv.getByPosition(position);
    }



}
