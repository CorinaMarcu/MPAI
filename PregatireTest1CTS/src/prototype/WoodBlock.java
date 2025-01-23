package prototype;

import java.util.Optional;

public class WoodBlock extends BuildingBlock{
    private byte[] texture;
    public WoodBlock(){
        System.out.println("WoodBlock constructor");
        texture= new byte[]{2,3,5};
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException();
        }
    }

    @Override
   public Object clone() throws CloneNotSupportedException {
        WoodBlock woodBlock= (WoodBlock) super.clone();
        if(texture!=null){
            woodBlock.texture=texture.clone();
        } else{
            woodBlock.texture=null;
        }
        return woodBlock;
    }

    @Override
    public void render() {
        System.out.println("Rendering the wood block at " + getX() + " " + getY() + " " + getZ());
    }
}
