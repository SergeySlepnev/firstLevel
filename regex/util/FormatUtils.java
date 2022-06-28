package mentoring.levelone.javacoreleveltwo.regex.util;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FormatUtils {

    public static final String PHONE_REGEX = "(\\+?375)?[\\s|-]?(\\(?\\d{2}\\)?)[\\s|-]?(\\d{3})[\\s|-]?(\\d{2})[\\s|-]?(\\d{2})";
    public static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_REGEX);
    public static final String COMMA = ",";
    public static final String CODE = "+375";
    private static final String SPACE = " ";
    private static final String HYPHEN = "-";

    private FormatUtils() {
    }

    public static String findAndFormatPhoneNumber(String data) {
        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(data);
        String phoneNumber = "";
        String digitsInBrackets = "";
        String threeDigits = "";
        String twoDigits = "";
        String twoDigitsTwo = "";
        while (matcher.find()) {
            digitsInBrackets = matcher.group(2).replaceAll("[()]", "");
            threeDigits = matcher.group(3);
            twoDigits = matcher.group(4);
            twoDigitsTwo = matcher.group(5);
            phoneNumber = CODE + SPACE + "(" + digitsInBrackets + ")" + SPACE + threeDigits + HYPHEN + twoDigits + HYPHEN + twoDigitsTwo;
        }
        return phoneNumber;
    }

    public static String formatDateTime(LocalDateTime now) {
        return now.toString().replaceAll("T", " ");
    }
}