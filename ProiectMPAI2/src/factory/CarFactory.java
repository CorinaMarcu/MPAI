package factory;

import model.Car;
import model.Vehicle;

public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(int id) {
        return new Car(id, 0);
    }
}

