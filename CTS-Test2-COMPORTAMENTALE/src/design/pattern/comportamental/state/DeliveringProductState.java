package design.pattern.comportamental.state;

public class DeliveringProductState implements VendingMachineState{
    @Override
    public void display() {
        System.out.println("Pick up the product!");
    }
}
