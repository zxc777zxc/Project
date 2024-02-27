package com.example.hotelmanage.servise;

import com.example.hotelmanage.model.Staff;
import com.example.hotelmanage.represetory.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class StaffServiceImpl implements StaffService{
    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public void addStaff(Staff staff) {

    }
}
