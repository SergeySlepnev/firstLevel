package mentoring.levelone.javacoreleveltwo.incapsulation;

public class ATMRunner {
    public static void main(String[] args) {
        ATM atm = new ATM(0, 0, 0);
        atm.addMoney(0,1, 2);
        boolean moneyWithdrawn = atm.isMoneyWithdrawn(100);
        System.out.println(moneyWithdrawn);
    }


}
