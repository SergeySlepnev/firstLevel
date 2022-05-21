package mentoring.levelone.javacoreleveltwo.incapsulation;

public class ATM {

    public static final int ONE_HUNDRED = 100;
    public static final int FIFTY = 50;
    public static final int TWENTY = 20;
    private int twentyDollarBanknote;
    private int fiftyDollarBanknote;
    private int oneHundredDollarBanknote;

    public ATM(int twentyDollarBanknote, int fiftyDollarBanknote, int oneHundredDollarBanknote) {
        this.twentyDollarBanknote = twentyDollarBanknote;
        this.fiftyDollarBanknote = fiftyDollarBanknote;
        this.oneHundredDollarBanknote = oneHundredDollarBanknote;
    }

    public void addMoney(int depositedMoney) {
        oneHundredDollarBanknote += depositedMoney / ONE_HUNDRED;
        depositedMoney %= ONE_HUNDRED;
        fiftyDollarBanknote += depositedMoney / FIFTY;
        depositedMoney %= FIFTY;
        twentyDollarBanknote += depositedMoney / TWENTY;
    }

    public void addMoney(int oneHundredDollarBanknote, int fiftyDollarBanknote, int twentyDollarBanknote) {
        this.oneHundredDollarBanknote += oneHundredDollarBanknote;
        this.fiftyDollarBanknote += fiftyDollarBanknote;
        this.twentyDollarBanknote += twentyDollarBanknote;
    }

    public boolean isMoneyWithdrawn(int requiredMoney) {
        int currentMoney = requiredMoney;
        if (countCurrentMoneyInATM() < currentMoney || currentMoney < 20) {
            return false;
            //всё, что ниже, вроде работает, но вообще не читабельно. Как можно поправить?
        } else {
            //нужно ли инициализировать локальные переменные?
            int oneHundredBanknote;
            int fiftyBanknote;
            int twentyBanknote;
            if (currentMoney % ONE_HUNDRED == 10 || currentMoney % ONE_HUNDRED == 30) {
                int hundredMoney = (currentMoney / ONE_HUNDRED - 1) * ONE_HUNDRED;
                oneHundredBanknote = Math.min(hundredMoney / ONE_HUNDRED, oneHundredDollarBanknote);
                currentMoney -= oneHundredBanknote * ONE_HUNDRED;
            } else {
                if (currentMoney / ONE_HUNDRED <= oneHundredDollarBanknote) {
                    oneHundredBanknote = currentMoney / ONE_HUNDRED;
                    currentMoney %= ONE_HUNDRED;
                } else {
                    currentMoney -= oneHundredDollarBanknote * ONE_HUNDRED;
                    oneHundredBanknote = oneHundredDollarBanknote;
                }
            }
            if (currentMoney % FIFTY == 10 || currentMoney % FIFTY == 30) {
                int fiftyMoney = (currentMoney / FIFTY - 1) * FIFTY;
                fiftyBanknote = Math.min(fiftyMoney / FIFTY, fiftyDollarBanknote);
                currentMoney -= fiftyBanknote * FIFTY;
            } else {
                if (currentMoney / FIFTY <= fiftyDollarBanknote) {
                    fiftyBanknote = currentMoney / FIFTY;
                    currentMoney %= FIFTY;
                } else {
                    currentMoney -= fiftyDollarBanknote * FIFTY;
                    fiftyBanknote = fiftyDollarBanknote;
                }
            }
            if (currentMoney / TWENTY <= twentyDollarBanknote) {
                twentyBanknote = currentMoney / TWENTY;
            } else {
                return false;
            }
            printWithdrawnBanknotes(oneHundredBanknote, fiftyBanknote, twentyBanknote);
        }
        return true;
    }

    private int countCurrentMoneyInATM() {
        return oneHundredDollarBanknote * ONE_HUNDRED +
                fiftyDollarBanknote * FIFTY +
                twentyDollarBanknote * TWENTY;
    }

    private void printWithdrawnBanknotes(int oneHundredBanknote, int fiftyBanknote, int twentyBanknote) {
        System.out.println("Count of one hundred dollar banknotes = " + oneHundredBanknote + "\n" +
                "Count of fifty dollar banknotes = " + fiftyBanknote + "\n" +
                "Count of twenty dollar banknotes = " + twentyBanknote);
    }

    public int getTwentyDollarBanknote() {
        return twentyDollarBanknote;
    }

    public void setTwentyDollarBanknote(int twentyDollarBanknote) {
        this.twentyDollarBanknote = twentyDollarBanknote;
    }

    public int getFiftyDollarBanknote() {
        return fiftyDollarBanknote;
    }

    public void setFiftyDollarBanknote(int fiftyDollarBanknote) {
        this.fiftyDollarBanknote = fiftyDollarBanknote;
    }

    public int getOneHundredDollarBanknote() {
        return oneHundredDollarBanknote;
    }

    public void setOneHundredDollarBanknote(int oneHundredDollarBanknote) {
        this.oneHundredDollarBanknote = oneHundredDollarBanknote;
    }
}
