package model;

public class Car extends Vehicle {
    public Car(int id, int capacity) {
        super(id, capacity);
        this.type = "Car";
    }

    @Override
    public void displayInfo() {
        System.out.println("Acesta este un autovehicul de tip Car cu capacitatea de " + capacity + " persoane.");
    }
}
