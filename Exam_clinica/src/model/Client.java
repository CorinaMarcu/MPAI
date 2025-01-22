package model;

import observer.Observer;

public class Client implements Observer {
    private String name;
    private String address;

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + "', address='" + address + "'}";
    }

    @Override
    public void update(String message) {
        System.out.println(name + ", " + message);
    }
}
