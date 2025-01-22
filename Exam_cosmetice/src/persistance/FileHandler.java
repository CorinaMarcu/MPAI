package persistance;

import model.Order;
import model.OrderState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_PATH="orders.txt";

    public static void saveOrders(List<Order> orders) throws IOException{
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(FILE_PATH)))
        {
            for(Order order:orders){
                writer.write(order.getOrderId()+","+order.getClientName()+","+order.getState());
                writer.newLine();
            }
        }
    }

    public static List<Order> loadOrders() throws IOException{
        List<Order> orders=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while((line= reader.readLine())!=null){
                String[] parts=line.split(",");
                orders.add(new Order(parts[0],parts[1], OrderState.valueOf(parts[2])));

            }
        }
        return orders;
    }
}
