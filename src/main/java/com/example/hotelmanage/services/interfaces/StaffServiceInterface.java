package com.example.hotelmanage.services.interfaces;

import com.example.hotelmanage.models.Staff;

import java.util.List;

public interface StaffServiceInterface {
    List<Staff> getAll();
    Staff getById(int id);

    Staff create(Staff staff);

    List<Staff> getByName(String name);

    List<Staff> getByPosition(String position);

    void deleteById(int id);


    Staff increaseSalary(int id, double amount);

    Staff decreaseSalary(int id, double amount);
}
