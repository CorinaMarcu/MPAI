package design.pattern.structural.adapter;

import java.sql.SQLOutput;

public class OldGame implements AbstractOldGame{
    @Override
    public void oldGameMethod() {
        System.out.println("Old game method");
    }
}
