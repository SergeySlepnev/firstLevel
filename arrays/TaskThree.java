package mentoring.levelone.javacorelevelone.arrays;

/**
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других:
 * с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 */
public class TaskThree {

    public static void main(String[] args) {
        int[] intArray = {-4, 0, -1, -9, 0, -18, -3};
        getAndPrintTwoDimensionalArray(intArray);
    }

    private static void getAndPrintTwoDimensionalArray(int[] intArray) {
        int[][] deepIntArray = getTwoDimensionalArray(intArray);
        for (int i = 0; i < 3; i++) {
            int[] currentRow = deepIntArray[i];
            for (int rowElement : currentRow) {
                System.out.print(rowElement + " ");
            }
            System.out.println();
            System.out.println("--------");
        }
    }

    private static int[][] getTwoDimensionalArray(int[] intArray) {
        int[][] twoDimensionalArray = new int[3][];
        twoDimensionalArray[0] = getArrayOfNegative(intArray);
        twoDimensionalArray[1] = getArrayOfZero(intArray);
        twoDimensionalArray[2] = getArrayOfPositive(intArray);
        return twoDimensionalArray;
    }

    private static int[] getArrayOfPositive(int[] intArray) {
        int arraySize = 0;
        for (int element : intArray) {
            if (element > 0) {
                arraySize++;
            }
        }
        int[] arrayOfPositive = new int[arraySize];
        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (intArray[i] > 0) {
                arrayOfPositive[j] = intArray[i];
                j++;
            }
        }
        return arrayOfPositive;
    }

    private static int[] getArrayOfNegative(int[] intArray) {
        int arraySize = 0;
        for (int element : intArray) {
            if (element < 0) {
                arraySize++;
            }
        }
        int[] arrayOfNegative = new int[arraySize];
        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (intArray[i] < 0) {
                arrayOfNegative[j] = intArray[i];
                j++;
            }
        }
        return arrayOfNegative;
    }

    private static int[] getArrayOfZero(int[] intArray) {
        int arraySize = 0;
        for (int element : intArray) {
            if (element == 0) {
                arraySize++;
            }
        }
        int[] arrayOfZero = new int[arraySize];
        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (intArray[i] == 0) {
                arrayOfZero[j] = intArray[i];
                j++;
            }
        }
        return arrayOfZero;
    }
}
