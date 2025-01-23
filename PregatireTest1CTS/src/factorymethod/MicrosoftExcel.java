package factorymethod;

public class MicrosoftExcel implements Document{

    private String name;

    MicrosoftExcel(){

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
        System.out.println("Opening the MicrosoftExcel "+name);
    }

}
