package design.pattern.structural.proxy;

public class WebsiteAuthenticationProxy implements AuthenticationService{

    private int numberOfFailedAttempts = 0;
    private final AuthenticationService authenticationService;

    public WebsiteAuthenticationProxy(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public boolean login(String username, String password) {
        if(numberOfFailedAttempts > 2){
            return false;
        } else{
            boolean isLoginSuccessful = authenticationService.login(username,password);
            if(isLoginSuccessful){
                numberOfFailedAttempts=0;
            } else{
                numberOfFailedAttempts++;
            }
            return isLoginSuccessful;
        }
    }
}
