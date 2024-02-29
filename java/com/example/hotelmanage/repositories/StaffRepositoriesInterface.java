package com.example.hotelmanage.repositories;


import com.example.hotelmanage.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepositoriesInterface extends JpaRepository<Staff,Integer> {
    List<Staff> getByName(String name);
    List<Staff> getByPosition(String name);


}
