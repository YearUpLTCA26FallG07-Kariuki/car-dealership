package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    public static Dealership getInventory() {

        Dealership dealership = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));

            // read the dealership information
            String line = reader.readLine();
            String[] dealershipInfo = line.split("\\|");
            dealership = new Dealership(
                    dealershipInfo[0],
                    dealershipInfo[1],
                    dealershipInfo[2]
            );
            // read the vehicle information
            while ((line = reader.readLine()) != null) {

                String[] vehicleInfo = line.split("\\|");

                Vehicle vehicle = new Vehicle(
                        vehicleInfo[0],
                        Integer.parseInt(vehicleInfo[1]),
                        vehicleInfo[2],
                        vehicleInfo[3],
                        vehicleInfo[4],
                        vehicleInfo[5],
                        Integer.parseInt(vehicleInfo[6]),
                        Double.parseDouble(vehicleInfo[7])
                );

                dealership.addVehicle(vehicle);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading the inventory file.");
        }
        return dealership;
    }
}