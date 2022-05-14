package mentoring.levelone.javacorelevelone.arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа
 * (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * Далее определить среднее арифметическое всех элементов целочисленного массива и
 * вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */

public class TaskTwo {

    public static void main(String[] args) {
        char[] chars = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        printElementsGraterThanMean(chars);
    }

    private static void printElementsGraterThanMean(char[] charArray) {
        int[] intArray = getArrayOfInt(charArray);
        int mean = getArithmeticMeanOfArray(intArray);
        for (int element : intArray) {
            if (element > mean) {
                System.out.println(element);
            }
        }
    }

    private static int[] getArrayOfInt(char[] charArray) {
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i];
        }
        return intArray;
    }

    private static int getArithmeticMeanOfArray(int[] intArray) {
        int sumOfArrayElement = 0;
        for (int element : intArray) {
            sumOfArrayElement += element;
        }
        return sumOfArrayElement / intArray.length;
    }
}
