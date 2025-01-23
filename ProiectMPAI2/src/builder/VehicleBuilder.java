package builder;

import model.Vehicle;
import model.Car;
import model.Truck;

public class VehicleBuilder {
    private String type;
    private int id;
    private int capacity;

    public VehicleBuilder(String type) {
        this.type = type;
    }

    public VehicleBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public VehicleBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Vehicle buildVehicle() {
        if (type.equals("Car")) {
            return new Car(id, capacity);
        } else if (type.equals("Truck")) {
            return new Truck(id, capacity);
        }
        throw new IllegalArgumentException("Tip vehicul necunoscut: " + type);
    }
}
