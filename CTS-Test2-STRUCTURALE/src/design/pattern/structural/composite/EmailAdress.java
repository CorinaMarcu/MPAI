package design.pattern.structural.composite;

public class EmailAdress implements EmailReceiver{

    private String adress;

    public EmailAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public void receive(String text) {
        System.out.println(adress + ": " + text);

    }

    @Override
    public void addReceiver(EmailReceiver emailReceiver) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteReceiver(EmailReceiver emailReceiver) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EmailReceiver getReceiver(int index) {
        throw new UnsupportedOperationException();
    }
}
