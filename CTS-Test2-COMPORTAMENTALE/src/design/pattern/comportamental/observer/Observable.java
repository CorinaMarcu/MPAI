package design.pattern.comportamental.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer){
        if(!observers.contains(observer))
            observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }
    public void notifyObserver(String message){
        for(Observer observer : observers){
            observer.receiveNotification(message);
        }
    }

}
