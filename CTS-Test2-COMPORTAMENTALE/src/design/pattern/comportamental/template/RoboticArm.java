package design.pattern.comportamental.template;

public class RoboticArm extends PartMover{
    @Override
    protected void liftPart() {
        System.out.println("A robotic arm lifts the part");
    }

    @Override
    protected void transportPart() {
        System.out.println("A robotic arm transports the part");
    }

    @Override
    protected void dropPart() {
        System.out.println("A robotic arm drops the part");
    }
}
