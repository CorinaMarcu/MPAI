package design.pattern.comportamental.state;

public class ReturningChangeState implements VendingMachineState{
    @Override
    public void display() {
        System.out.println("Pick up the change!");
    }
}
