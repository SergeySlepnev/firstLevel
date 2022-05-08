package mentoring.levelone.javacorelevelone.homework.functions;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */
public class TaskOne {
    public static void main(String[] args) {
        int minutes = 7;
        getQuoterOfHour(minutes);
    }

    public static void getQuoterOfHour(int minutes) {
        if (minutes >= 0 && minutes <= 15) {
            System.out.println("The first quoter.");
        } else if (minutes >= 16 && minutes <= 30) {
            System.out.println("The second quoter.");
        } else if (minutes >= 31 && minutes <= 45) {
            System.out.println("The third quoter");
        } else {
            System.out.println("The fourth quoter.");
        }
    }
}