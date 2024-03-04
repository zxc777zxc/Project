package com.example.hotelmanage.repositories;

import com.example.hotelmanage.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepositoriesInterface extends JpaRepository<Client,Integer> {
    List<Client> getByName(String name);
}
