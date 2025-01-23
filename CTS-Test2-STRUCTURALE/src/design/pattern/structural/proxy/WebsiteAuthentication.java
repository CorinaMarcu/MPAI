package design.pattern.structural.proxy;

public class WebsiteAuthentication implements AuthenticationService{
    public static final String PASSWORD = "admin";
    public static final String USERNAME = "admin";

    @Override
    public boolean login(String username, String password) {
        return PASSWORD.equals(password) && USERNAME.equals(username);
    }
}
