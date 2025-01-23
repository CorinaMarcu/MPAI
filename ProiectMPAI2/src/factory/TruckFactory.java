package factory;

import model.Truck;
import model.Vehicle;

public class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(int id) {
        return new Truck(id,0);
    }
}
