package design.pattern.comportamental.template;

public class Worker extends PartMover{
    @Override
    protected void liftPart() {
        System.out.println("A worker lifts the part");
    }

    @Override
    protected void transportPart() {
        System.out.println("A worker transports the part");
    }

    @Override
    protected void dropPart() {
        System.out.println("A worker drops the part");
    }
}
