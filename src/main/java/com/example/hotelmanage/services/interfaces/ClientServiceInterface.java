package com.example.hotelmanage.services.interfaces;

import com.example.hotelmanage.models.Client;

import java.util.List;

public interface ClientServiceInterface {
    List<Client> getAll();
    Client getById(int id);

    Client create(Client client);

    List<Client> getByName(String name);

    void deleteById(int id);
}
