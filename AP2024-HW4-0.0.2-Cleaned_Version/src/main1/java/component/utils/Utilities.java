package component.utils;

import java.util.Random;

public class Utilities {
    public static int rng(int min, int max) {
        Random random = new Random();
        return (int) random.doubles(min, max)
                .findFirst()
                .getAsDouble();
    }
}
