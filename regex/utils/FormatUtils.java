package regex.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FormatUtils {

    public static final String PHONE_REGEX = "(\\+?375)?[\\s|-]?(\\(?\\d{2}\\)?)[\\s|-]?(\\d{3})[\\s|-]?(\\d{2})[\\s|-]?(\\d{2})";
    public static final String DATE_TIME_REGEX = "(\\d{4}-\\d{2}-\\d{2})T(\\d{2}:\\d{2})";
    public static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_REGEX);
    public static final Pattern DATE_TIME_PATTERN = Pattern.compile(DATE_TIME_REGEX);
    public static final String COMMA = ",";
    public static final String CODE = "+375";
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";

    private FormatUtils() {
    }

    public static String findAndFormatPhoneNumber(String data) {
        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(data);
        String phoneNumber = "";
        if (matcher.find()) {
            String digitsInBrackets = matcher.group(2).replaceAll("[()]", "");
            String threeDigits = matcher.group(3);
            String twoDigits = matcher.group(4);
            String twoDigitsTwo = matcher.group(5);
            phoneNumber = CODE + SPACE + "(" + digitsInBrackets + ")" + SPACE + threeDigits + HYPHEN + twoDigits + HYPHEN + twoDigitsTwo;
        }
        return phoneNumber;
    }

    public static String findAndFormatDateTime(String data) {
        Matcher matcher = DATE_TIME_PATTERN.matcher(data);
        String dateTime = "";
        if (matcher.find()) {
            return matcher.group(1) + SPACE + matcher.group(2);
        }
        return dateTime;
    }
}