package singletone;

import exception.InvalidLoggerInstanceException;

import java.time.LocalDateTime;

public class Logger {
    private static Logger instance = null;
    private Logger(){
    }

    public static synchronized Logger getLogger(){
        if (instance == null){
            instance = new Logger();
        }
        else{
            throw new InvalidLoggerInstanceException();
        }
        return instance;
    }

    public void log(String message) { System.out.println(LocalDateTime.now() + ": " + message);}
}
