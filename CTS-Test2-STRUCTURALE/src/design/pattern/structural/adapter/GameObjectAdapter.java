package design.pattern.structural.adapter;

public class GameObjectAdapter implements AbstractNewGame{

    private AbstractOldGame oldGame;

    public GameObjectAdapter(AbstractOldGame oldGame) {
        this.oldGame = oldGame;
    }

    @Override
    public void newGameMethod() {

        oldGame.oldGameMethod();
    }
}
