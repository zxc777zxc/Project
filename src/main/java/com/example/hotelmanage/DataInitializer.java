package com.example.hotelmanage.component;

import com.example.hotelmanage.represetory.ClientRepository;
import com.example.hotelmanage.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        // Создание и сохранение сущностей Client
        clientRepository.save(new Client("John Doe", 1));
        clientRepository.save(new Client("Jane Doe", 2));
    }
}
