package factorymethod;

public class MicrosoftWord implements Document{
    private String name;

    MicrosoftWord(){

    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void open() {
        System.out.println("Opening the MicrosoftWord named "+name);
    }
}
