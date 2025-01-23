package prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeCollection {
    private Map<String,BuildingBlock> map= new HashMap<>();

    public PrototypeCollection(){
        map.put("WOOD", new WoodBlock());
        map.put("STONE", new StoneBlock());
    }
    public BuildingBlock getBlock (String key)
    {
        try{
            return (BuildingBlock) map.get(key).clone();
        } catch(Exception e){
            return null;
        }

    }

}
