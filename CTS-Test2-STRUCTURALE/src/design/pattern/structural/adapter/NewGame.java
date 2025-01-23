package design.pattern.structural.adapter;

public class NewGame implements AbstractNewGame{

    @Override
    public void newGameMethod() {
        System.out.println("New game method");
    }
}
