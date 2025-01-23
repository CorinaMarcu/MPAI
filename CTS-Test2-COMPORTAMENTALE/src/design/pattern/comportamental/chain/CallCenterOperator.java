package design.pattern.comportamental.chain;

public class CallCenterOperator extends CallCenterHandler{
    public static final int OPERATOR_TRESHOLD = 1000;
    @Override
    public void refund(float sum) {
        if(sum < OPERATOR_TRESHOLD){
            System.out.println("Suma a fost aprobata de operator!");
        } else{
            if(nextHandler != null) {
                nextHandler.refund(sum);
            }
        }
    }
}


