package mentoring.levelone.javacoreleveltwo.regex.util;

import java.util.Random;

public final class ThreadUtils {

    public static final Random RANDOM = new Random();
    public static final long INCOMING_CALL_PERIOD = 1500L;
    public static final long MIN_HANDLING_TIME = 500L;
    public static final long MAX_HANDLING_TIME = 1500L;
    public static final long READ_NEW_COMPLAINTS_PERIOD = 10L;

    private ThreadUtils() {
    }

    public static long handlingTime() {
        return RANDOM.nextLong(MIN_HANDLING_TIME, MAX_HANDLING_TIME + 1);
    }
}