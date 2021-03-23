package bank;

public class BankAccount {
    private static final double COMISSION_CASH = 0.05;
    private static final double COMISSION_TRANSFER = 0.01;
    public static double profitBank;

    private final String name;
    private double count;

    public BankAccount(String name, double count) {
        this.name = name;
        this.setCount(count);
    }

    public void setCount(double count) {
        if (count < 0) {
            throw new IllegalArgumentException("Остаток на счете не должен быть отриц.числом");
        } else {
            this.count = count;
        }
    }

    public double getCount() {
        return count;
    }

    public void add(double money) {
        this.count = (1 - COMISSION_CASH) * money;
        profitBank += COMISSION_CASH * money;
    }

    public void transfer(BankAccount otherPerson, double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Сумма перевода не может быть отриц.числом");
        } else if (this.getCount() - money < 0) {
            throw new IllegalArgumentException("Недостаточно денег на счете");
        } else {
            otherPerson.setCount(otherPerson.getCount() + money * (1 - COMISSION_TRANSFER));
            this.count -= money;
            profitBank += COMISSION_TRANSFER * money;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
