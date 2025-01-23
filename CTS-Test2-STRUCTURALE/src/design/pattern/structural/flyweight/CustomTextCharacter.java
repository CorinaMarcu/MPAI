package design.pattern.structural.flyweight;

public class CustomTextCharacter implements AbstractTextCharacter{

    private char character;
    private byte[] image;

    public CustomTextCharacter(char character, byte[] image) {
        this.character = character;
        this.image = image;
    }

    @Override
    public void display(int x, int y) {
        System.out.println(character + " -> " + x + "," + y);
    }
}
