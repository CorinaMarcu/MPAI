package model;

public class Request {
    private String requestId;
    private Client client;
    private String problemDescription;
    private RequestState state;

    public Request(String requestId, Client client, String problemDescription, RequestState state) {
        this.requestId = requestId;
        this.client = client;
        this.problemDescription = problemDescription;
        this.state = state;
    }

    public String getRequestId() {
        return requestId;
    }

    public Client getClient() {
        return client;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public RequestState getState() {
        return state;
    }

    public void setState(RequestState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Request{id='" + requestId + "', client=" + client +
                ", description='" + problemDescription + "', state=" + state + "}";
    }
}
