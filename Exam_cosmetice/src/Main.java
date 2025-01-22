import model.Order;
import model.OrderState;
import observer.Client;
import persistance.FileHandler;
import service.OrderManager;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        OrderManager manager = new OrderManager();
        Client client1 = new Client("Alice");
        Client client2 = new Client("Bob");
        Client client3 = new Client("Miriam");

        manager.addObserver(client1);
        manager.addObserver(client2);
        manager.addObserver(client3);

        manager.addOrder(new Order("1", "Alice", OrderState.REGISTERED));
        manager.addOrder(new Order("2", "Bob", OrderState.PREPARED));
        manager.addOrder(new Order("3", "Miriam", OrderState.PREPARED));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. View Orders");
            System.out.println("2. Filter Orders");
            System.out.println("3. Change Order State");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.viewOrders().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Enter state to filter (REGISTERED, PREPARED, DELIVERED): ");
                    OrderState state = OrderState.valueOf(scanner.next().toUpperCase());
                    manager.filterOrders(state).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter Order ID: ");
                    String id = scanner.next();
                    System.out.println("Enter new state (REGISTERED, PREPARED, DELIVERED): ");
                    OrderState newState = OrderState.valueOf(scanner.next().toUpperCase());
                    manager.changeOrderState(id, newState);
                    break;
                case 4:
                    FileHandler.saveOrders(manager.viewOrders());
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
