package com.example.hotelmanage.controllers;

import com.example.hotelmanage.models.Client;
import com.example.hotelmanage.services.interfaces.ClientServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientServiceInterface serv;

    public ClientController(ClientServiceInterface serv) {
        this.serv = serv;
    }



    @GetMapping("/getAll")
    public List<Client> getAll(){
        return serv.getAll();
    }

    @GetMapping("/{ClientID}")
    public ResponseEntity<Client> getById(@PathVariable("ClientID") int id){
        Client client = serv.getById(id);
        if(client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("addClient")
    public ResponseEntity<Client> create(@RequestBody Client client){
        Client createdClient = serv.create(client);
        if(createdClient == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED); //201
    }

    @GetMapping("/name/{ClientName}")
    public List<Client> getAllByName(@PathVariable("ClientName") String name){
        return serv.getByName(name);
    }

    @DeleteMapping("delID/{ClientID}")
    public ResponseEntity<Void> deleteById(@PathVariable("ClientID") int id) {
        Client client = serv.getById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        serv.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
