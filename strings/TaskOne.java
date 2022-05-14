package mentoring.levelone.javacoreleveltwo.strings;

import java.util.Arrays;
import java.util.Locale;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом.
 * Также удалить пробелы. Результат привести к верхнему регистру.
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = "   abc Cpddd Dio OsfWw";
        String output = replaceDuplicates(input);
        System.out.println("output = " + output);
    }

    private static String replaceDuplicates(String input) {
        char[] chars = input.toUpperCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    chars[j] = ' ';
                }
            }
        }
        return new String(chars).replace(" ", "");
    }
}
