package manager;

import model.Vehicle;
import java.util.List;

public class SystemManager {
    private static SystemManager instance;
    private List<Vehicle> vehicles;

    private SystemManager(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public static SystemManager getInstance(List<Vehicle> vehicles) {
        if (instance == null) {
            instance = new SystemManager(vehicles);
        }
        return instance;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void allocateVehicle(Vehicle vehicle) {
        vehicle.setStatus("indisponibil");
        System.out.println("Vehiculul " + vehicle.getType() + " a fost alocat.");
    }
}
