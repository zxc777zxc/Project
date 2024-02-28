package com.example.hotelmanage;
import java.sql.PreparedStatement;


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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class HotelManageApplication implements CommandLineRunner {

    private final ClientService clientService;
    private final StaffService staffService;

    @Autowired
    public HotelManageApplication(ClientService clientService, StaffService staffService) {
        this.clientService = clientService;
        this.staffService = staffService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HotelManageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner sc = new Scanner(System.in); // Используйте try-with-resources для Scanner
             Connection connection = DriverManager.getConnection("jdbc:your_database", "user", "password")) { // Подключение к БД

            Client client = new Client("John Doe", 500);
            Staff staff1 = new Staff("Alice Johnson", "Waiter", 15);
            Staff staff2 = new Staff("Bob Smith", "Chef", 20);

            staff1.addHoursWorked(40);
            staff2.addHoursWorked(45);

            staff1.paySalary();
            staff2.paySalary();

            clientService.addClient(client);
            bookTheRoom(connection, client); // Правильный вызов метода

            staffService.addStaff(staff1);
            staffService.addStaff(staff2);
        } catch (SQLException e) {
            System.out.println("Database connection failure: " + e.getMessage());
        }
    }

    public static void bookTheRoom(Connection connection, Client client) throws SQLException {
        Room[] allRooms = Room.getAllRooms();
        String sql = "UPDATE room SET booked = ? WHERE price = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) { // Используйте try-with-resources для PreparedStatement
            statement.setString(1, client.getName());
            statement.setInt(2, client.chooseRoom(allRooms).getPrice());
            statement.executeUpdate();
        }
    }
}
