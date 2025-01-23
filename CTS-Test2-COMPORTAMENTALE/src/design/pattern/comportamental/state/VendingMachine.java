package design.pattern.comportamental.state;

public class VendingMachine {
    private VendingMachineState vendingMachineState;
    private double moneyInserted;

    public VendingMachine() {
        vendingMachineState = new AcceptingMoneyState();
        vendingMachineState.display();
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public void insertMoney(double sum){
        moneyInserted += sum;
        setVendingMachineState(new SelectingProductState());
        vendingMachineState.display();
    }

    public void selectProduct(double price){
        if(price <= moneyInserted){
            setVendingMachineState(new DeliveringProductState());
            vendingMachineState.display();
        }
        if(moneyInserted - price > 0){
            setVendingMachineState(new ReturningChangeState());
            vendingMachineState.display();
            moneyInserted=0;
        }
        setVendingMachineState(new AcceptingMoneyState());
        vendingMachineState.display();
    }
}
