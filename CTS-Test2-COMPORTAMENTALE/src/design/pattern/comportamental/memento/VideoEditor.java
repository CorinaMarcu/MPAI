package design.pattern.comportamental.memento;

public class VideoEditor {
    private HistoryManager historyManager;
    private Video video;

    public VideoEditor() {
        historyManager = new HistoryManager();
        video = new Video();
        video.setName("Video 1");
    }
    public void edit(int length){
        video.setLength(video.getLength()+length);
    }
    public void ctrlS(){
        historyManager.save(video);
    }
    public void ctrlZ(){
        video = historyManager.undo();
    }

    @Override
    public String toString() {
        return "length: " + video.getLength();
    }
}
