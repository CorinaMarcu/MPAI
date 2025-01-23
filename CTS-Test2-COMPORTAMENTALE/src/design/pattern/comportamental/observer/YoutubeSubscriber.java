package design.pattern.comportamental.observer;

public class YoutubeSubscriber implements Observer{
    @Override
    public void receiveNotification(String message) {
        System.out.println(message);
    }
}
