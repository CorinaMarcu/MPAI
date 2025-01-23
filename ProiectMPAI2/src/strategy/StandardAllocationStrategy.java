package strategy;

import model.Vehicle;

public class StandardAllocationStrategy implements AllocationStrategy {
    @Override
    public void allocate(Vehicle vehicle) {
        System.out.println("Alocare standardă pentru vehiculul " + vehicle.getType());
    }
}
