package design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class EmailGroup  implements EmailReceiver{

    private List<EmailReceiver> receiverList = new ArrayList<>();
    private String adress;

    public EmailGroup(String adress) {
        this.adress = adress;
    }

    @Override
    public void receive(String text) {
        for(EmailReceiver r : receiverList){
            r.receive(text);
        }

    }

    @Override
    public void addReceiver(EmailReceiver emailReceiver) {
        receiverList.add(emailReceiver);
    }

    @Override
    public void deleteReceiver(EmailReceiver emailReceiver) {
        receiverList.remove(emailReceiver);
    }

    @Override
    public EmailReceiver getReceiver(int index) {
        if(index>=0 && index< receiverList.size()){
            return receiverList.get(index);
        }
        throw new RuntimeException("Invalid id");
    }

}
