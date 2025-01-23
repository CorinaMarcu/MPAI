package design.pattern.structural.composite;

public interface EmailReceiver {
    void receive(String text);
    void addReceiver(EmailReceiver emailReceiver);
    void deleteReceiver(EmailReceiver emailReceiver);
    EmailReceiver getReceiver(int index);
}
