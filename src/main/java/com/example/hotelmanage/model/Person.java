package com.example.hotelmanage.model;


import lombok.Data;
@Data
public class Person {
    public Person() {
        // конструктор по умолчанию
    }
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}
