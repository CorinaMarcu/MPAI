import model.Client;
import model.Request;
import model.RequestState;
import observer.RequestManager;
import persistance.FileHandler;
import util.IdGenerator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Load clients and requests from files
        List<Client> clients = FileHandler.loadClients("src/clients.txt");
        List<Request> requests = FileHandler.loadRequests("src/requests.txt", clients);

        // Initialize RequestManager and add existing requests
        RequestManager manager = new RequestManager();
        for (Request request : requests) {
            manager.addRequest(request);
        }

        // Add clients as observers
        clients.forEach(manager::addObserver);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Request");
            System.out.println("2. View Requests");
            System.out.println("3. Filter Requests");
            System.out.println("4. Change Request State");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter client name: ");
                    String name = scanner.next();
                    System.out.println("Enter client address: ");
                    String address = scanner.next();
                    System.out.println("Enter problem description: ");
                    String description = scanner.next();

                    Client client = new Client(name, address);
                    clients.add(client);
                    String id = IdGenerator.generateId();
                    Request request = new Request(id, client, description, RequestState.IN_ANALYSIS);
                    manager.addRequest(request);

                    // Save new client and request to the respective files
                    FileHandler.saveClients("src/clients.txt", clients);
                    FileHandler.saveRequests("src/requests.txt", manager.viewRequests());
                }
                case 2 -> manager.viewRequests().forEach(System.out::println);
                case 3 -> {
                    System.out.println("Enter state to filter (IN_ANALYSIS, ACCEPTED, REJECTED, TEAM_DISPATCHED): ");
                    RequestState state = RequestState.valueOf(scanner.next().toUpperCase());
                    manager.filterRequests(state).forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println("Enter request ID: ");
                    String id = scanner.next();
                    System.out.println("Enter new state (IN_ANALYSIS, ACCEPTED, REJECTED, TEAM_DISPATCHED): ");
                    RequestState newState = RequestState.valueOf(scanner.next().toUpperCase());
                    manager.changeRequestState(id, newState);

                    // Save updated requests to the file
                    FileHandler.saveRequests("src/requests.txt", manager.viewRequests());
                }
                case 5 -> {
                    // Save all data before exiting
                    FileHandler.saveClients("src/clients.txt", clients);
                    FileHandler.saveRequests("src/requests.txt", manager.viewRequests());
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
