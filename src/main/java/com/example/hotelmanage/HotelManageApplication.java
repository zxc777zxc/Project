package com.example.hotelmanage;

import com.example.hotelmanage.servise.ClientService;
import com.example.hotelmanage.servise.StaffService;

import com.example.hotelmanage.model.Client;
import com.example.hotelmanage.model.Staff;
import com.example.hotelmanage.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class HotelManageApplication implements CommandLineRunner{

    private final ClientService clientService;
    private final StaffService staffService;

    @Autowired
    public HotelManageApplication(ClientService clientService, StaffService staffService){
        this.clientService=clientService;
        this.staffService=staffService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HotelManageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Client client = new Client("John Doe", 500);

        Staff staff1 = new Staff("Alice Johnson", "Waiter", 15);
        Staff staff2 = new Staff("Bob Smith", "Chef", 20);

        staff1.addHoursWorked(40);
        staff2.addHoursWorked(45);

        staff1.paySalary();
        staff2.paySalary();

        clientService.addClient(client);
        bookTheRoom(client);

        staffService.addStaff(staff1);
        staffService.addStaff(staff2);
    }

    public static void bookTheRoom(Connection connection, Client client) throws SQLException {
        Room[] allRooms = Room.getAllRooms();
        String sql = "update room set booked=? where price=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, client.getName());
        statement.setInt(2, Integer.parseInt(Integer.toString(client.chooseRoom(allRooms).getPrice())));
        statement.executeUpdate();
    }
}
