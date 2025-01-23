import manager.SystemManager;
import model.Vehicle;
import strategy.AllocationStrategy;
import strategy.PriorityAllocationStrategy;
import strategy.StandardAllocationStrategy;
import factory.VehicleFactory;
import factory.CarFactory;
import factory.TruckFactory;
import model.Car;
import model.Truck;
import builder.VehicleBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize vehicles from file
        List<Vehicle> vehicles = loadVehiclesFromFile("src/vehicleDataBase.txt");

        // Initialize SystemManager (Singleton)
        SystemManager manager = SystemManager.getInstance(vehicles);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // User menu
        System.out.println("Choose user type:");
        System.out.println("1. Admin");
        System.out.println("2. User");
        int userType = scanner.nextInt();

        if (userType == 1) {
            handleAdmin(scanner, manager); // Admin adds vehicle
        } else if (userType == 2) {
            handleUser(scanner, manager); // User makes vehicle request
        } else {
            System.out.println("Invalid option!");
        }
    }

    // Admin adds vehicle
    private static void handleAdmin(Scanner scanner, SystemManager manager) {
        System.out.println("Admin - Add vehicle:");
        System.out.println("1. Add Car");
        System.out.println("2. Add Truck");
        int vehicleType = scanner.nextInt();
        scanner.nextLine();  // Consume the line

        System.out.println("Enter vehicle capacity:");
        int capacity = scanner.nextInt();

        // Create vehicle
        Vehicle vehicle = createVehicle(vehicleType, capacity);
        if (vehicle != null) {
            manager.addVehicle(vehicle);

            // Save vehicle to file
            saveVehicleToFile(vehicle);
            System.out.println("Vehicle added successfully!");
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    // User makes request and chooses allocation strategy
    private static void handleUser(Scanner scanner, SystemManager manager) {
        System.out.println("Choose request type:");
        System.out.println("1. Request for passenger transport");
        System.out.println("2. Request for freight transport");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the line

        // Choose available vehicle
        Vehicle vehicle = getAvailableVehicle(option);

        if (vehicle == null) {
            System.out.println("No available vehicles for the chosen request.");
            return;
        }

        // Choose allocation strategy
        System.out.println("Choose allocation strategy:");
        System.out.println("1. Priority allocation");
        System.out.println("2. Standard allocation");
        int strategyOption = scanner.nextInt();
        AllocationStrategy strategy = strategyOption == 1 ? new PriorityAllocationStrategy() : new StandardAllocationStrategy();

        // Allocate the vehicle
        manager.allocateVehicle(vehicle);
        strategy.allocate(vehicle);

        // Log user request to file
        logUserRequest(vehicle);

        // Display vehicle details to user
        System.out.println("The allocated vehicle is:");
        System.out.println("ID: " + vehicle.getId());
        System.out.println("Type: " + vehicle.getType());
        System.out.println("Capacity: " + vehicle.getCapacity());

        // Update vehicle status in the file
        updateVehicleStatusInFile(vehicle);
    }

    // Create vehicle based on admin's selection (using Factory and Builder)
    private static Vehicle createVehicle(int vehicleType, int capacity) {
        VehicleFactory factory = null;

        // Choose the appropriate factory for the vehicle type
        if (vehicleType == 1) {
            factory = new CarFactory();
        } else if (vehicleType == 2) {
            factory = new TruckFactory();
        }

        // Create vehicle using the selected factory
        if (factory != null) {
            Vehicle vehicle = factory.createVehicle(generateVehicleId());

            // Use Builder to configure vehicle details
            VehicleBuilder builder = new VehicleBuilder(vehicle.getType());
            builder.setCapacity(capacity); // Set vehicle capacity
            builder.setId(vehicle.getId());
            return builder.buildVehicle(); // Return the fully constructed vehicle
        }

        return null;
    }

    // Find an available vehicle based on user request
    private static Vehicle getAvailableVehicle(int option) {
        for (Vehicle vehicle : SystemManager.getInstance(null).getVehicles()) {
            if ((option == 1 && vehicle.getType().equals("Car")) ||
                    (option == 2 && vehicle.getType().equals("Truck"))) {
                if (vehicle.getStatus().equals("available")) {
                    return vehicle;
                }
            }
        }
        return null; // No available vehicles
    }

    // Save vehicle to data file
    private static void saveVehicleToFile(Vehicle vehicle) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/vehicleDataBase.txt", true))) {
            writer.write("ID: " + vehicle.getId() + ", Type: " + vehicle.getType() + ", Capacity: " + vehicle.getCapacity() + ", Status: " + vehicle.getStatus() + "\n");
        } catch (IOException e) {
            System.err.println("Error saving vehicle: " + e.getMessage());
        }
    }

    // Update vehicle status in file
    private static void updateVehicleStatusInFile(Vehicle vehicle) {
        List<Vehicle> vehicles = SystemManager.getInstance(null).getVehicles();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/vehicleDataBase.txt"))) {
            for (Vehicle v : vehicles) {
                if (v.getId() == vehicle.getId()) {
                    v.setStatus("unavailable");
                }
                writer.write("ID: " + v.getId() + ", Type: " + v.getType() + ", Capacity: " + v.getCapacity() + ", Status: " + v.getStatus() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error updating vehicle status: " + e.getMessage());
        }
    }

    // Log user request to a file
    private static void logUserRequest(Vehicle vehicle) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/userRequests.txt", true))) {
            writer.write("User request for allocated vehicle:\n");
            writer.write("Vehicle ID: " + vehicle.getId() + "\n");
            writer.write("Type: " + vehicle.getType() + "\n");
            writer.write("Capacity: " + vehicle.getCapacity() + "\n");
            writer.write("---------------------------------------------------\n");
        } catch (IOException e) {
            System.err.println("Error logging user request: " + e.getMessage());
        }
    }

    // Load vehicles from file
    private static List<Vehicle> loadVehiclesFromFile(String filename) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                int id = Integer.parseInt(parts[0].split(": ")[1]);
                String type = parts[1].split(": ")[1];
                int capacity = Integer.parseInt(parts[2].split(": ")[1]);
                String status = parts[3].split(": ")[1];

                Vehicle vehicle = null;
                if (type.equals("Car")) {
                    vehicle = new Car(id, capacity);
                } else if (type.equals("Truck")) {
                    vehicle = new Truck(id, capacity);
                }
                if (vehicle != null) {
                    vehicle.setStatus(status);
                    vehicles.add(vehicle);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading vehicles from file: " + e.getMessage());
        }
        return vehicles;
    }

    // Auxiliary function to generate a unique vehicle ID
    // Auxiliary function to generate a unique vehicle ID based on the last ID in the file
    private static int generateVehicleId() {
        int lastId = 0; // Default to 0 if file is empty
        try (BufferedReader reader = new BufferedReader(new FileReader("src/vehicleDataBase.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                int id = Integer.parseInt(parts[0].split(": ")[1]);
                lastId = Math.max(lastId, id);  // Update the last ID found in the file
            }
        } catch (IOException e) {
            System.err.println("Error reading vehicle data: " + e.getMessage());
        }
        return lastId + 1;  // Increment the last ID and return it
    }

}
