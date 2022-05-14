package mentoring.levelone.javacoreleveltwo.strings;

import java.util.Arrays;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * Посчитать сумму всех чисел из строки
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class TaskTwo {

    public static void main(String[] args) {
        String input = "Привет 9, как 1 2 твои дела? Может4, сделать 3 дело?";
        int[] result = getArrayOfDigits(input);
        int sum = getSum(result);
        System.out.println(Arrays.toString(result));
        System.out.println(sum);
    }

    private static int getSum(int[] inputArray) {
        int sum = 0;
        for (int i : inputArray) {
            sum += i;
        }
        return sum;
    }

    private static int[] getArrayOfDigits(String input) {
        int size = getSize(input);
        int[] output = new int[size];
        for (int i = 0, j = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                output[j] = Character.getNumericValue(input.charAt(i));
                j++;
            }
        }
        return output;
    }

    private static int getSize(String input) {
        int size = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                size++;
            }
        }
        return size;
    }
}
