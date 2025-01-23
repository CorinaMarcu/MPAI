import design.pattern.comportamental.chain.CallCenterManager;
import design.pattern.comportamental.chain.CallCenterOperator;
import design.pattern.comportamental.chain.ChiefFinancialOfficer;
import design.pattern.comportamental.command.BurgerOrder;
import design.pattern.comportamental.command.Chef;
import design.pattern.comportamental.command.PizzaOrder;
import design.pattern.comportamental.command.Waiter;
import design.pattern.comportamental.memento.VideoEditor;
import design.pattern.comportamental.observer.YoutubeChannel;
import design.pattern.comportamental.observer.YoutubeSubscriber;
import design.pattern.comportamental.state.VendingMachine;
import design.pattern.comportamental.state.VendingMachineState;
import design.pattern.comportamental.strategy.Calculator;
import design.pattern.comportamental.strategy.Operation;
import design.pattern.comportamental.strategy.StrategyNotSetException;
import design.pattern.comportamental.strategy.SumOperation;
import design.pattern.comportamental.template.PartMover;
import design.pattern.comportamental.template.RoboticArm;
import design.pattern.structural.adapter.*;
import design.pattern.structural.composite.EmailAdress;
import design.pattern.structural.composite.EmailGroup;
import design.pattern.structural.composite.EmailReceiver;
import design.pattern.structural.decorator.*;
import design.pattern.structural.facade.CarFacade;
import design.pattern.structural.flyweight.AbstractTextCharacter;
import design.pattern.structural.flyweight.CustomTextCharacterFactory;
import design.pattern.structural.proxy.AuthenticationService;
import design.pattern.structural.proxy.WebsiteAuthentication;
import design.pattern.structural.proxy.WebsiteAuthenticationProxy;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //---------------------------STRUCTURALE-------------------------

        //Adapter
        AbstractNewGame newGame = new NewGame();
        newGame.newGameMethod();

        AbstractOldGame oldGame = new OldGame();
        oldGame.oldGameMethod();

        newGame = new GameObjectAdapter(oldGame);
        newGame.newGameMethod();

        newGame = new GameClassAdapter();
        newGame.newGameMethod();

        //Facade
        CarFacade carFacade = new CarFacade();
        carFacade.start();
        carFacade.emergencyBrake();

        /*//Proxy
        AuthenticationService authenticationService =
                new WebsiteAuthenticationProxy(new WebsiteAuthentication());
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            System.out.println("username: ");
            String username = scanner.nextLine();
            System.out.println("password: ");
            String password = scanner.nextLine();
            System.out.println(
                    authenticationService.login(username,password));
        }*/

        //Composite
        EmailReceiver email1 = new EmailAdress("lescaiedenisa");
        EmailReceiver email2 = new EmailAdress("paulcopaceanu");
        EmailReceiver group1 = new EmailGroup("g1");
        group1.addReceiver(email1);
        group1.addReceiver(email2);
        group1.receive("Grup1");
        EmailReceiver group2 = new EmailGroup("g2");
        EmailReceiver email3 = new EmailAdress("cabuleavictor");
        group2.addReceiver(group1);
        group2.addReceiver(email3);
        group2.receive("Grup2");

        //Flyweight
        CustomTextCharacterFactory factory = new CustomTextCharacterFactory();
        AbstractTextCharacter textCharacter1 = factory.getTextCharacter('A');
        textCharacter1.display(1,5);
        AbstractTextCharacter textCharacter2 = factory.getTextCharacter('B');
        textCharacter2.display(2,6);
        AbstractTextCharacter textCharacter3 = factory.getTextCharacter('A');
        textCharacter3.display(3,7);
        System.out.println(textCharacter1 == textCharacter3);

        //Decorator
        Vehicle car = new Car();
        car.start();
        car.stop();
        CarWithAlarm carWithAlarm = new CarWithAlarm(car);
        carWithAlarm.stop();
        CarWithSportSeats carWithSportSeats = new CarWithSportSeats(car);
        carWithSportSeats.setSeatProducer("Ferrari");

        //--------------------------COMPORTAMENTALE------------------------

        //chain
        CallCenterOperator operator = new CallCenterOperator();
        CallCenterManager manager = new CallCenterManager();
        ChiefFinancialOfficer officer = new ChiefFinancialOfficer();
        operator.setNextHandler(manager);
        manager.setNextHandler(officer);
        operator.refund(100);
        operator.refund(1000);
        operator.refund(5000);
/*
        //command
        Waiter waiter = new Waiter();
        Chef chef = new Chef();
        waiter.takeOrder(new PizzaOrder(chef));
        waiter.takeOrder(new BurgerOrder(chef));
        waiter.takeOrder(new PizzaOrder(chef));
        waiter.sendOrdersToChef();*/

        //strategy
        Calculator calculator = new Calculator();
        calculator.setOperation(new SumOperation());
        try{
            Double result = calculator.calculate(1,2,3);
            System.out.println(result);
        } catch (StrategyNotSetException e){
            throw new RuntimeException(e);
        }

        //state
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(20);
        vendingMachine.selectProduct(10);

        //observer
        YoutubeChannel youtubeChannel = new YoutubeChannel("Denisa");
        YoutubeSubscriber youtubeSubscriber1 = new YoutubeSubscriber();
        YoutubeSubscriber youtubeSubscriber2 = new YoutubeSubscriber();
        youtubeChannel.subscribe(youtubeSubscriber1);
        youtubeChannel.subscribe(youtubeSubscriber2);
        youtubeChannel.publishVideo();
        youtubeChannel.unsubscribe(youtubeSubscriber2);
        youtubeChannel.publishVideo();

        //memento
        VideoEditor videoEditor = new VideoEditor();
        videoEditor.edit(7);
        videoEditor.ctrlS();
        System.out.println(videoEditor.toString());
        videoEditor.edit(5);
        videoEditor.ctrlS();
        System.out.println(videoEditor.toString());
        videoEditor.edit(2);
        System.out.println(videoEditor.toString());
        videoEditor.ctrlZ();
        System.out.println(videoEditor.toString());

        //template
        PartMover partMover = new RoboticArm();
        partMover.movePart();
    }
}