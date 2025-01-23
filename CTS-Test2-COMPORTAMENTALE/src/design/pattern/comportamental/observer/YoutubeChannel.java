package design.pattern.comportamental.observer;

public class YoutubeChannel extends Observable{

    private String name;
    public YoutubeChannel(String name) {
        this.name = name;
    }
    public void publishVideo(){
        super.notifyObserver(name + " a postat un nou videoclip!");
    }
}
