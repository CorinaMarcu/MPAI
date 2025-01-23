package model;

public class Truck extends Vehicle {
    public Truck(int id, int capacity) {
        super(id, capacity);
        this.type = "Truck";
    }

    @Override
    public void displayInfo() {
        System.out.println("Acesta este un autovehicul de tip Truck cu capacitatea de " + capacity + " tone.");
    }
}
