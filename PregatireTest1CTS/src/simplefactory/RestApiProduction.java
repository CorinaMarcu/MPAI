package simplefactory;

public class RestApiProduction implements RestApi{

    RestApiProduction(){

    }
    @Override
    public void post(String message) {
        System.out.println("POST: " + message);
    }

    @Override
    public String get() {
        return "PRODUCTION GET";
    }

    @Override
    public void delete(int id) {
        System.out.println("DELETE: " + id);
    }
}
