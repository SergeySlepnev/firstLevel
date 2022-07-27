package regex.utils;

import java.util.List;
import java.util.Random;

public final class RandomUtils {

    private static final Random RANDOM = new Random();

    private static final List<String> phoneNumbers = List.of(
            "+375 29 999 78 90", "333652193",
            "+375 29 999 78 90", "+375 30 989 78 91",
            "+375 25-777-77-51", "33 365 21-43",
            "+3752 577-77-885", "3339352-193",
            "+375 55 999 78 94", "+375 33 989 78 97",
            "+375 25-777-77-00", "33 365 81-43",
            "+3752 577-77-896", "33 391 78-19"
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

    private static final List<String> supportStaffName = List.of(
            "Ivan", "Michail", "Natalya", "Petr", "Masha",
            "Vera", "Kirill", "Stepan", "Katerina", "Vladimir"
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

    public static String randomName() {
        return supportStaffName.get(randomIndex(supportStaffName));
    }
}
