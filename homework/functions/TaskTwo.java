package mentoring.levelone.javacorelevelone.homework.functions;

/**
 * Даны 3 переменные:
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 */
public class TaskTwo {
    public static void main(String[] args) {

        double operand1 = 7;
        double operand2 = 0;
        char operation = '/';
        double result = getResult(operand1, operand2, operation);
        System.out.println(result);
        double resultV2 = getResultV2(operand1, operand2, operation);
        System.out.println(resultV2);
    }

    private static double getResult(double operand1, double operand2, char operation) {
        double result = 0;
        if (operation == '+') {
            result = operand1 + operand2;
        } else if (operation == '-') {
            result = operand1 - operand2;
        } else if (operation == '*') {
            result = operand1 * operand2;
        } else if (operation == '/') {
            result = operand1 / operand2;
        } else if (operation == '%') {
            result = operand1 % operand2;
        } else {
            System.out.print("The operation is not correct. Try again. ");
            return result;
        }
        if (!Double.isFinite(result)) {
            System.out.print("Warning! The result is ");
            return result;
        }
        return result;
    }

    private static double getResultV2(double operand1, double operand2, char operation) {
        double result = 0;
        switch (operation) {
            case '+' -> result = operand1 + operand2;
            case '-' -> result = operand1 - operand2;
            case '*' -> result = operand1 * operand2;
            case '/' -> result = operand1 / operand2;
            case '%' -> result = operand1 % operand2;
            default -> System.out.print("The operation is not correct. Try again. ");
        }
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            System.out.print("Warning! The result is ");
            return result;
        }
        return result;
    }

}