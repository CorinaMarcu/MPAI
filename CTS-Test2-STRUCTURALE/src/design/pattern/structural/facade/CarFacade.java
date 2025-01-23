package design.pattern.structural.facade;

public class CarFacade {

    Engine engine = new Engine();
    BrakingSystem brakingSystem = new BrakingSystem();
    LightiningSystem lightiningSystem = new LightiningSystem();

    public void emergencyBrake(){
        engine.setLoad(0);
        brakingSystem.applyFrontBrakes();
        brakingSystem.applyRearBrakes();
        lightiningSystem.turnOnHazardLights();
    }

    public void start(){

        lightiningSystem.turnOnLowBeam();
        brakingSystem.resetBrakes();
        engine.setLoad(10);
    }
}
