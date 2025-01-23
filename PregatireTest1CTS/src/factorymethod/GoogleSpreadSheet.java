package factorymethod;

public class GoogleSpreadSheet implements Document{

    private String name;

    GoogleSpreadSheet(){

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
        System.out.println("Opening the GoogleSpreadSheet named "+name);
    }
}
