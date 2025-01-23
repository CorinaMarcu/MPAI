package prototype;

public class StoneBlock extends BuildingBlock{

    private byte[] texture;
    public StoneBlock()
    {
        System.out.println("StoneBlock constructor...");
        texture=new byte[]{1,2,3};
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void render() {
        System.out.println("Rendering the stone block at " + getX() + " " + getY() + " " + getZ());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        StoneBlock stoneBlock=(StoneBlock) super.clone();
        if(texture!=null){
            stoneBlock.texture=texture.clone();
        } else {
            stoneBlock.texture=null;
        }
        return stoneBlock;
    }
}
