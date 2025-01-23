package design.pattern.comportamental.memento;

public class Video implements Cloneable{
    private int length;
    private String name;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Video video = (Video) super.clone();
        video.length = this.length;
        video.name = this.name;
        return video;
    }
}
