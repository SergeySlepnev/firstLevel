package mentoring.levelone.javacorelevelone.arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы
 * (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 */
public class TaskOne {

    public static void main(String[] args) {
        int[] intArray = {0, 5, -6, 3, 10, -9, 0, -123};
        int[] result = getNonNegativeArrayAndMultiplyItByFive(intArray);
        printArray(result);
    }

    private static int[] getNonNegativeArrayAndMultiplyItByFive(int[] intArray) {
        int[] nonNegativeArray = getNonNegativeArray(intArray);
        int length = nonNegativeArray.length;
        int[] resultArray = new int[length];
        for (int i = 0; i < length; i++) {
            resultArray[i] = nonNegativeArray[i] * 5;
        }
        return resultArray;
    }

    private static int[] getNonNegativeArray(int[] intArray) {
        int size = getSizeOfNonNegativeArray(intArray);
        int[] nonNegativeArray = new int[size];
        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (intArray[i] >= 0) {
                nonNegativeArray[j] = intArray[i];
                j++;
            }
        }
        return nonNegativeArray;
    }

    private static int getSizeOfNonNegativeArray(int[] intArray) {
        int size = 0;
        for (int element : intArray) {
            if (element >= 0) {
                size++;
            }
        }
        return size;
    }

    private static void printArray(int[] inputArray) {
        for (int element : inputArray) {
            System.out.print(element + " ");
        }
    }
}
