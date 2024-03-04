package com.example.hotelmanage.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String position;
    private double salary;
    private int rate;
    private int workedHours;
}
