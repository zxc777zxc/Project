package com.example.hotelmanage.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="room")
public class Room {
    private String type;
    private String bedtype;
    private int price;
    private String booked;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
