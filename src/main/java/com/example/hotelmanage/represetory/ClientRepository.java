package com.example.hotelmanage.represetory;


import org.springframework.data.repository.CrudRepository;
import com.example.hotelmanage.model.Client;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepository extends CrudRepository<Client,Long>{
    void addClient(Client client);

//    Object save(Client johnDoe);
}
