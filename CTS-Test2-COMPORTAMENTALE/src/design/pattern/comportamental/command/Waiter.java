package design.pattern.comportamental.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {

    List<FoodOrder> orders = new ArrayList<>();

    public void takeOrder(FoodOrder foodOrder){
        orders.add(foodOrder);
    }

    public void sendOrdersToChef(){
        for(FoodOrder foodOrder : orders){
            foodOrder.prepare();
        }
        orders.clear();
    }
}
