package com.example.hotelmanage.servise;

import com.example.hotelmanage.model.Client;
import com.example.hotelmanage.represetory.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void addClient(Client client) {
        // Здесь должна быть логика добавления клиента, например:
        clientRepository.addClient(client);
    }
}
