package mentoring.levelone.javacorelevelone.homework.loops;

/**
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 */
public class TaskTwo {

    public static void main(String[] args) {

        int number = 4700;
        int reversed = reverseInteger(number);
        System.out.println(reversed);

    }
    private static int reverseInteger(int input) {
        int reversed = 0;
        while (input != 0) {
            int digit = input % 10;
            reversed = reversed * 10 + digit;
            input /= 10;
        }
        return reversed;
    }

}
