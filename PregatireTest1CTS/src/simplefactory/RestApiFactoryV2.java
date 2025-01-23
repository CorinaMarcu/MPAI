package simplefactory;

import exception.InvalidServerTypeException;

public class RestApiFactoryV2 {
    public final static String DEVELOPMENT = "Development";
    public final static String PRODUCTION = "Production";

    public RestApi getApi(String serverType){
        if(DEVELOPMENT.equals(serverType))
            return new RestApiDevelopment();
        else if(PRODUCTION.equals(serverType))
            return new RestApiProduction();
        else {
            throw new InvalidServerTypeException();
        }
    }

}
