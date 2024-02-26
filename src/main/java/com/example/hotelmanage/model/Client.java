package com.example.hotelmanage.model;

import lombok.Data;

import java.util.Scanner;

@Data
public class Client extends Person{

    private int money;
    private Room room;

    public Client(String name, int money) {
        super(name);
        this.money = money;
    }


    public Room chooseRoom(Room[] rooms) {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        System.out.println(this.getName() + "please choose room type:");

        int choice;

        do {

            System.out.println("Rooms:");
            for (int i = 0; i < rooms.length; i++) {
                System.out.println((i + 1) + ": " + rooms[i]);
            }


            System.out.print("Choose room:");
            choice = sc.nextInt();

            if (choice > 0 && choice <= rooms.length && money>=rooms[choice-1].getPrice()) {
                System.out.println(this.getName()+" choose room: " + rooms[choice - 1]);
                return rooms[choice - 1];
            } else if (choice != 0 && choice>rooms.length) {
                System.out.println("There is no such room");
                return null;
            }

            System.out.println(this.getName() + " doesn't have enough money for this room. Choose other room or enter '0' to exit");
        } while (choice != 0);


        System.out.println(this.getName() + " doesn't have enough money for any room.");


        return null;
    }

}
