package com.example.hotelmanage.services;

import com.example.hotelmanage.models.Client;
import com.example.hotelmanage.repositories.ClientRepositoriesInterface;
import com.example.hotelmanage.services.interfaces.ClientServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService implements ClientServiceInterface {

    private final ClientRepositoriesInterface rep;

    public ClientService(ClientRepositoriesInterface rep) {
        this.rep = rep;
    }

    @Override
    public List<Client> getAll() {
        return rep.findAll();
    }

    @Override
    public Client getById(int id) {
        return rep.findById(id).orElse(null);
    }

    @Override
    public Client create(Client client) {
        return rep.save(client);
    }

    @Override
    public List<Client> getByName(String name) {
        return rep.getByName(name);
    }

    @Override
    public void deleteById(int id) {
        rep.deleteById(id);
    }
}
