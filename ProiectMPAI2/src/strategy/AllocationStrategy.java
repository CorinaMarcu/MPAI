package strategy;

import model.Vehicle;

public interface AllocationStrategy {
    void allocate(Vehicle vehicle);
}