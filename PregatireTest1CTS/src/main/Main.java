package main;

import builder.AbstractHolidayPackage;
import builder.Director;
import builder.HolidayPackage;
import exception.InvalidLoggerInstanceException;
import exception.InvalidServerTypeException;
import factorymethod.*;
import prototype.BuildingBlock;
import prototype.PrototypeCollection;
import prototype.WoodBlock;
import simplefactory.RestApi;
import simplefactory.RestApiFactory;
import simplefactory.RestApiFactoryV2;
import simplefactory.ServerType;
import singletone.Logger;

public class Main {
    public static void main(String[] args) {

        //SINGLETONE
        try {
            Logger logger = Logger.getLogger();
            logger.log("The logger instance");
            Thread t=new Thread(()->{
                //Logger lol = Logger.getLogger();
                //lol.log("Second logger");
            });
            t.start();



        } catch(InvalidLoggerInstanceException e ){
            e.printStackTrace();
        }

        //SIMPLEFACTORY
        try {
            RestApiFactory restApiFactory = new RestApiFactory();
            RestApi restApi = restApiFactory.getRestApi(ServerType.PRODUCTION);
            System.out.println(restApi.get());

            RestApiFactory restApiFactory2= new RestApiFactory();
            RestApi restApi2 = restApiFactory2.getRestApi(ServerType.DEVELOPMENT);
            System.out.println(restApi2.get());

            RestApiFactoryV2 restApiFactoryV2 = new RestApiFactoryV2();
            RestApi restApi1= restApiFactoryV2.getApi("Production");
            System.out.println(restApi1.get());


        } catch (InvalidServerTypeException e){
            e.printStackTrace();
        }

        //FACTORY METHOD
        AbstractDocumentFactory documentFactory = new GoogleDocumentFactory();
        Document document = documentFactory.getDocument(DocumentType.TEXT);
        document.setName("Proiecrt1");
        document.open();

        documentFactory = new MicrosoftDocumentFactory();
        Document document2 = documentFactory.getDocument(DocumentType.SHEET);
        document2.setName("Proiectr2");
        document2.open();

        //BUILDER
        HolidayPackage.HolidayPackageBuilder builder= new HolidayPackage.HolidayPackageBuilder();
        Director director = new Director(builder);
        HolidayPackage holidayPackageFain = director.createholidayPackage1();
        System.out.println(holidayPackageFain);

        //PROTOTYPE
        BuildingBlock buildingBlock= new WoodBlock();
        buildingBlock.setX(1);
        buildingBlock.setY(2);
        buildingBlock.setZ(3);
        buildingBlock.render();

        BuildingBlock block2 = null;
        try{
            block2=(BuildingBlock) buildingBlock.clone();
            block2.render();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        PrototypeCollection prototypeCollection= new PrototypeCollection();
        BuildingBlock block3= prototypeCollection.getBlock("WOOD");
        BuildingBlock block4= prototypeCollection.getBlock("WOOD");
        block3.render();
    }
}