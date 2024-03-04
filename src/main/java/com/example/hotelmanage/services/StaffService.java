package com.example.hotelmanage.services;

import com.example.hotelmanage.models.Staff;
import com.example.hotelmanage.repositories.StaffRepositoriesInterface;
import com.example.hotelmanage.services.interfaces.StaffServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService implements StaffServiceInterface{

    private final StaffRepositoriesInterface rep;

    public StaffService(StaffRepositoriesInterface rep) {
        this.rep = rep;
    }


    @Override
    public List<Staff> getAll() {
        return rep.findAll();
    }

    @Override
    public Staff getById(int id) {
        return rep.findById(id).orElse(null);
    }

    @Override
    public Staff create(Staff staff) {
        return rep.save(staff);
    }

    @Override
    public List<Staff> getByName(String name) {
        return rep.getByName(name);
    }

    @Override
    public List<Staff> getByPosition(String position) {
        return rep.getByPosition(position);
    }

    @Override
    public void deleteById(int id) {
        rep.deleteById(id);
    }

    @Override
    public Staff increaseSalary(int id, double increaseAmount) {
        Staff staff = getById(id);
        if (staff != null) {
            double currentSalary = staff.getSalary();
            double newSalary = currentSalary + increaseAmount;
            staff.setSalary(newSalary);
            return rep.save(staff);
        }
        return null;
    }

    @Override
    public Staff decreaseSalary(int id, double decreaseAmount) {
        Staff staff = getById(id);
        if (staff != null) {
            double currentSalary = staff.getSalary();
            double newSalary = currentSalary - decreaseAmount;
            staff.setSalary(newSalary);
            return rep.save(staff);
        }
        return null;
    }

    @Override
    public Staff setSalary(int id, double Amount) {
        Staff staff = getById(id);
        if (staff != null) {
            double currentSalary = staff.getSalary();
            double newSalary = Amount;
            staff.setSalary(newSalary);
            return rep.save(staff);
        }
        return null;
    }


    @Override
    public Staff calculateSalary(int id, int rate, int workedHours) {
        Staff staff = getById(id);
        if (staff != null) {
            double currentSalary = staff.getSalary();
            double newSalary = rate*workedHours;
            staff.setSalary(newSalary);
            return rep.save(staff);
        }
        return null;
    }


}
