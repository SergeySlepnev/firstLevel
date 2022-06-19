package multithreading.util;

import java.util.Random;

public final class RandomUtils {

    public static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int getNextWithinBounds(int lowerBound, int upperBound) {
        return RANDOM.nextInt(lowerBound, upperBound + 1);
    }

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }
}