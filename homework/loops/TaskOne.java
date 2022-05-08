package mentoring.levelone.javacorelevelone.homework.loops;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция - нечетных).
 * <p>
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class TaskOne {

    public static void main(String[] args) {
        int input = 22255577;
        int evens = countEven(input);
        int odds = countOdd(input);
        System.out.printf("The number %d contains %d events and %d odds.", input, evens, odds);
    }
    private static int countEven(int input) {
        int counter = 0;
        for (int current = input; current != 0; current /= 10) {
            int reminderByTen = current % 10;
            if (reminderByTen % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    private static int countOdd(int input) {
        int counter = 0;
        for (int current = input; current != 0; current /= 10) {
            int reminderByTen = current % 10;
            if (reminderByTen % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }

}
