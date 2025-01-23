package design.pattern.comportamental.command;

public class Chef {

    public void bakePizza(){
        try{
            Thread.sleep(3000);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Pizza is ready!");
    }

    public void prepareBurger(){

       new Thread(()->{
           try{
               Thread.sleep(4000);
           } catch(InterruptedException e){
               throw new RuntimeException();
           }
           System.out.println("Burger is ready!");
        }).start();
    }

}
