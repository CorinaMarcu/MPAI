package model;

public abstract class Vehicle {
    protected int id;
    protected int capacity;
    protected String type;
    protected String status;

    public Vehicle(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.status = "available";
    }

    public abstract void displayInfo();

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
