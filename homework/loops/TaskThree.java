package mentoring.levelone.javacorelevelone.homework.loops;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию
 * Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с
 * доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 */
public class TaskThree {

    public static void main(String[] args) {

        int year = 3;
        int month = 2;
        int wage = 600;

        double sumOnVanyaAccount = getSumOnVanyaAccount(wage, year, month);
        System.out.println("sumOnVanyaAccount = " + sumOnVanyaAccount);
        double sumOnBrokerAccount = getSumOnBrokerAccount(wage, year, month);
        System.out.println("sumOnBrokerAccount = " + sumOnBrokerAccount);

    }
    private static double getSumOnVanyaAccount(int wage, int year, int month) {
        int months = countMonth(year, month);
        final int foodAndFun = 300;
        double sumOnVanyaAccount = 0;
        // как часто используются метки в циклах на практике?
        whileLoop:
        while (true) {
            for (int j = 1; j <= 6; j++) {
                double transferToBrokerAccount = wage * 0.1;
                double totalSpendPerMonth = foodAndFun + transferToBrokerAccount;
                sumOnVanyaAccount += wage - totalSpendPerMonth;//имена переменных не слишком длинные?
                months--;
                if (months == 0) {
                    break whileLoop;
                }
                if (j == 6) {
                    wage += 400;
                }
            }
        }
        return sumOnVanyaAccount;
    }

    private static double getSumOnBrokerAccount(int wage, int year, int month) {
        int months = countMonth(year, month);
        double sumOnBrokerAccount = wage * 0.1;
        for (int i = 2; i <= months; i++) {
            double percent = sumOnBrokerAccount * 0.02;
            double transferToBrokerAccount = wage * 0.1;
            sumOnBrokerAccount += percent + transferToBrokerAccount;
            if (i % 6 == 0) {
                wage += 400;
            }
        }
        return sumOnBrokerAccount;
    }

    private static int countMonth(int year, int month) {
        return year * 12 + month;
    }

}
