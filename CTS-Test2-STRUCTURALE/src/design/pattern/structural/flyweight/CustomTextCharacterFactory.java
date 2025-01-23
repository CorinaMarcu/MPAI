package design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CustomTextCharacterFactory {
    private Map<Character, CustomTextCharacter> map = new HashMap<>();

    public AbstractTextCharacter getTextCharacter(Character character){
        if(!map.containsKey(character)){
            map.put(character, new CustomTextCharacter(character,new byte[]{1,2}));
        }
        return map.get(character);
    }
}
