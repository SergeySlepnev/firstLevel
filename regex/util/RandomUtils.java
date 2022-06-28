package mentoring.levelone.javacoreleveltwo.regex.util;

import java.util.List;
import java.util.Random;

public final class RandomUtils {

    private static final Random RANDOM = new Random();

    private static final List<String> phoneNumbers = List.of(
            "+375 29 999 78 91", "+375 30 989 78 95",
            "+37525-777-77-53", "33 356 52 43",
            "+375257777885", "33 392 52-19",
            "+375 55 999 78 99", "+375 33 989 78 99",
            "+375 25-777-77-09", "33 356 58 14",
            "+375 25777 7896", "33 394 78-19"
    );

    private static final List<String> lastNames = List.of(
            "Abramson", "James", "Jenkin", "Audley", "Brooks",
            "Mercer", "Carter", "Clapton", "Derrick", "Ellington"
    );

    private static final List<String> firstNames = List.of(
            "Oliver", "Jack", "Harry", "Jacob", "Charley",
            "Thomas", "George", "Oscar", "Maxim", "Will"
    );

    private static final List<String> complaintContent = List.of(
            "Broken wire", "Weak signal", "light does not turn on",
            "TV is not working", "cat climbed a tree", "dog ate router"
    );

    private RandomUtils() {
    }

    private static int randomIndex(List<String> list) {
        return RANDOM.nextInt(list.size());
    }
    public static String randomPhoneNumber() {
        return phoneNumbers.get(randomIndex(phoneNumbers));
    }

    public static String randomLastName() {
        return lastNames.get(randomIndex(lastNames));
    }

    public static String randomFirstName() {
        return firstNames.get(randomIndex(firstNames));
    }

    public static String randomContent() {
        return complaintContent.get(randomIndex(complaintContent));
    }
}