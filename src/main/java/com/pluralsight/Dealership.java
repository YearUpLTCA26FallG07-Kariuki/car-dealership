package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String city;
    private String state;
    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
        vehicles = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    // search by the car's price
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                results.add(vehicle);
            }
        }
        return results;
    }
    // search for the make and model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make)
                    && vehicle.getModel().equalsIgnoreCase(model)) {
                results.add(vehicle);
            }
        }
        return results;
    }
    // search the car's year
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                results.add(vehicle);
            }
        }
        return results;
    }

    // search the car's color
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                results.add(vehicle);
            }
        }
        return results;
    }
    // search the car's mileage
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                results.add(vehicle);
            }
        }
        return results;
    }
    // let it search by the vehicle type
    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                results.add(vehicle);
            }
        }
        return results;
    }
    // remove the vehicle using its VIN
    public void removeVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin().equalsIgnoreCase(vin)) {
                vehicles.remove(vehicle);
                break;
            }
        }
    }
}