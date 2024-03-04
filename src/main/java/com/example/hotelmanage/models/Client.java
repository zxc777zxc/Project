package com.example.hotelmanage.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double money;
}
