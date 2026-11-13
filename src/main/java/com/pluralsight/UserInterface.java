package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        dealership = DealershipFileManager.getInventory();
        scanner = new Scanner(System.in);
    }

    public void display() {

        int command;

        do {
            System.out.println("\n===== " + dealership.getName() + " =====");
            System.out.println("1 - Find vehicles by price");
            System.out.println("2 - Find vehicles by make and model");
            System.out.println("3 - Find vehicles by year");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter your choice: ");

            command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();