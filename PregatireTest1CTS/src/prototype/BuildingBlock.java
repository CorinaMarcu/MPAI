package prototype;

public abstract class BuildingBlock implements Cloneable{

    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        BuildingBlock buildingBlock=(BuildingBlock) super.clone();
        buildingBlock.x=x;
        buildingBlock.y=y;
        buildingBlock.z=z;
        return buildingBlock;
    }
    public abstract void render();
}
