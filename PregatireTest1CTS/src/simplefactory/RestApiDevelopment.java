package simplefactory;

public class RestApiDevelopment implements RestApi{

    RestApiDevelopment(){

    }
    @Override
    public void post(String message) {
        System.out.println("POST: " + message);
    }

    @Override
    public String get() {
        return "DEVELOPMENT GET";
    }

    @Override
    public void delete(int id) {
        System.out.println("DELETE: " + id);
    }
}
