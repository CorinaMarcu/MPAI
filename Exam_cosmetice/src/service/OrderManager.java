package service;

import model.Order;
import model.OrderState;
import observer.OrderSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderManager extends OrderSubject {

    private List<Order> orders=new ArrayList<>();
    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> viewOrders(){
        return orders;
    }

    public List<Order> filterOrders(OrderState state){
        return orders.stream().filter(order -> order.getState()==state)
                .collect(Collectors.toList());
    }

    public void changeOrderState(String orderId,OrderState newState){
        for(Order order:orders)
        {
            if(order.getOrderId().equals(orderId)){
                order.setState(newState);
                //notificam obs
                notifyObservers("Order "+orderId+" is now "+newState);
                break;
            }
        }
    }
}
