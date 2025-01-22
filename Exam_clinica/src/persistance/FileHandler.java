package persistance;

import model.Client;
import model.Request;
import model.RequestState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Read clients from file
    public static List<Client> loadClients(String filename) {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String address = parts[1];
                clients.add(new Client(name, address));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    // Save clients to file
    public static void saveClients(String filename, List<Client> clients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Client client : clients) {
                writer.write(client.getName() + "," + client.getAddress() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read requests from file
    public static List<Request> loadRequests(String filename, List<Client> clients) {
        List<Request> requests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String clientName = parts[1];
                String description = parts[2];
                RequestState state = RequestState.valueOf(parts[3]);

                // Find client by name
                Client client = clients.stream()
                        .filter(c -> c.getName().equals(clientName))
                        .findFirst()
                        .orElse(null);

                if (client != null) {
                    requests.add(new Request(id, client, description, state));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requests;
    }

    // Save requests to file
    public static void saveRequests(String filename, List<Request> requests) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Request request : requests) {
                writer.write(request.getRequestId() + "," +
                        request.getClient().getName() + "," +
                        request.getProblemDescription() + "," +
                        request.getState() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
