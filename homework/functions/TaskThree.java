package mentoring.levelone.javacorelevelone.homework.functions;

/**
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */
public class TaskThree {

    public static void main(String[] args) {

        int aFirst = 2;
        int bFirst = 4;
        int aSecond = 6;
        int bSecond = 8;

        double squareFirst = getSquareOfTriangle(aFirst, bFirst);
        double squareSecond = getSquareOfTriangle(aSecond, bSecond);
        printPropertyOfTriangles(squareFirst, squareSecond);
    }
    private static double getSquareOfTriangle(int a, int b) {
        return (a * b) / 2.0;
    }

    private static void printPropertyOfTriangles(double squareFirst, double squareSecond) {
        String result = "";
        if (squareFirst > squareSecond) {
            result = "bigger than";
        } else if (squareFirst < squareSecond) {
            result = "less than";
        } else {
            result = "equals";
        }
        System.out.printf("The first triangle is %s the second one.", result);
    }
}
