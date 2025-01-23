package strategy;

import model.Vehicle;

public class PriorityAllocationStrategy implements AllocationStrategy {
    @Override
    public void allocate(Vehicle vehicle) {
        System.out.println("Alocare prioritară pentru vehiculul " + vehicle.getType());
    }
}
