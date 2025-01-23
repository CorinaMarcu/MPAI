package factorymethod;

public class GoogleDoc implements Document{

    private String name;

    GoogleDoc(){

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
        System.out.println("Opening the GoogleDoc named "+name);
    }
}
