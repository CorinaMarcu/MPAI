package design.pattern.comportamental.chain;

public class ChiefFinancialOfficer extends CallCenterHandler{
    @Override
    public void refund(float sum) {
        System.out.println("Suma a fost aprobata de CFO");
    }
}
