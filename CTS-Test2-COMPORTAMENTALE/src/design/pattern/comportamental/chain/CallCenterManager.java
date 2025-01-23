package design.pattern.comportamental.chain;

public class CallCenterManager extends CallCenterHandler {

    public static final int MANAGER_THRESHOLD = 5000;
    @Override
    public void refund(float sum) {
        if(sum < MANAGER_THRESHOLD){
            System.out.println("Suma aprobata de manager");
        } else{
            if(nextHandler != null){
                nextHandler.refund(sum);
            }
        }
    }
}

