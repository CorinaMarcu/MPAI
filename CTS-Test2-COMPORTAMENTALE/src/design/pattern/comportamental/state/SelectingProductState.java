package design.pattern.comportamental.state;

public class SelectingProductState implements VendingMachineState{
    @Override
    public void display() {
        System.out.println("Select a product!");
    }
}
