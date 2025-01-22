package observer;

import model.Client;
import model.Request;
import model.RequestState;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RequestManager extends Subject {
    private List<Request> requests = new ArrayList<>();

    public void addRequest(Request request) {
        requests.add(request);
        addObserver(request.getClient());
    }

    public List<Request> viewRequests() {
        return requests;
    }

    public List<Request> filterRequests(RequestState state) {
        return requests.stream()
                .filter(request -> request.getState() == state)
                .collect(Collectors.toList());
    }

    public void changeRequestState(String requestId, RequestState newState) {
        for (Request request : requests) {
            if (request.getRequestId().equals(requestId)) {
                request.setState(newState);

                // Notify the specific client about the state change
                String message = "Your request with ID " + requestId + " is now " + newState + ".";
                request.getClient().update(message);

                break;
            }
        }
    }
}
