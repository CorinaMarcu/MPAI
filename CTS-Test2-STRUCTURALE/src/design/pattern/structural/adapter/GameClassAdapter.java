package design.pattern.structural.adapter;

public class GameClassAdapter extends OldGame implements AbstractNewGame {
    @Override
    public void newGameMethod() {
        super.oldGameMethod();
    }
}
