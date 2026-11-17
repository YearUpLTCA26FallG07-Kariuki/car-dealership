package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    private final Dealership dealership;
    private final Scanner scanner;

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
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByTypeRequest();
                    break;
                case 7:
                    displayVehicles(dealership.getAllVehicles());
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (command != 99);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(
                    vehicle.getVin() + " | " +
                            vehicle.getYear() + " | " +
                            vehicle.getMake() + " | " +
                            vehicle.getModel() + " | " +
                            vehicle.getVehicleType() + " | " +
                            vehicle.getColor() + " | " +
                            vehicle.getOdometer() + " | $" +
                            vehicle.getPrice()
            );
        }
    }

    private void processGetByPriceRequest() {
        System.out.print("Minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Maximum price: ");
        double max = scanner.nextDouble();

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest() {
        System.out.print("Minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Maximum year: ");
        int max = scanner.nextInt();

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    private void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByMileageRequest() {
        System.out.print("Minimum mileage: ");
        int min = scanner.nextInt();
        System.out.print("Maximum mileage: ");
        int max = scanner.nextInt();

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    private void processGetByTypeRequest() {
        System.out.print("Vehicle type: ");
        String type = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processAddVehicleRequest() {
        System.out.print("VIN: ");
        String vin = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Vehicle type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Mileage: ");
        int mileage = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
        dealership.addVehicle(vehicle);

        DealershipFileManager.saveInventory(dealership);
        System.out.println("Vehicle added!");
    }

    private void processRemoveVehicleRequest() {
        scanner.nextLine();
        System.out.print("Enter VIN of vehicle to remove: ");
        String vin = scanner.nextLine();

        dealership.removeVehicle(vin);
        DealershipFileManager.saveInventory(dealership);

        System.out.println("Vehicle removed if VIN was found.");
    }
}