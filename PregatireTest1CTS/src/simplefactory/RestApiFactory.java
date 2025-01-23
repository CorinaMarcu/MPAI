package simplefactory;

import exception.InvalidServerTypeException;

import static simplefactory.ServerType.DEVELOPMENT;
import static simplefactory.ServerType.PRODUCTION;

public class RestApiFactory {

    public RestApi getRestApi(ServerType serverType) {
        switch (serverType) {
            case DEVELOPMENT:
                return new RestApiDevelopment();
            case PRODUCTION:
                return new RestApiProduction();
            default:
                throw new InvalidServerTypeException();
        }
    }
}
