package model;

public class Order {
    private String orderId;
    private String clientName;
    private OrderState state;

    public String getOrderId() {
        return orderId;
    }

    public Order(String orderId, String clientName, OrderState state) {
        this.orderId = orderId;
        this.clientName = clientName;
        this.state = state;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", state=" + state +
                '}';
    }
}
