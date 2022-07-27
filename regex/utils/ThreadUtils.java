package regex.utils;

import java.util.Random;

public final class ThreadUtils {

    public static final Random RANDOM = new Random();
    public static final long INCOMING_CALL_PERIOD = 5000L;
    public static final long MIN_HANDLING_TIME = 2000L;
    public static final long MAX_HANDLING_TIME = 4000L;
    public static final long READ_NEW_COMPLAINTS_PERIOD = 2L;

    private ThreadUtils() {
    }

    public static long handlingTime() {
        return RANDOM.nextLong(MIN_HANDLING_TIME, MAX_HANDLING_TIME + 1);
    }
}