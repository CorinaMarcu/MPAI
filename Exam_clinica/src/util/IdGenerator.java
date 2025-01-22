package util;

import java.util.Random;

public class IdGenerator {

    private static final Random RANDOM = new Random();

    // Generate a random ID between 1 and 100
    public static String generateId() {
        int id = RANDOM.nextInt(100) + 1;
        return String.valueOf(id);
    }
}
