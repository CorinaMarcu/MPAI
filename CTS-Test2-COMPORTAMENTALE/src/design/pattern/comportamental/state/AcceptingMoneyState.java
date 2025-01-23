package design.pattern.comportamental.state;

public class AcceptingMoneyState implements VendingMachineState{
    @Override
    public void display() {
        System.out.println("Please insert money!");
    }
}
