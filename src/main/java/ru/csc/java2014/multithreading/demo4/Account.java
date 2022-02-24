package ru.csc.java2014.multithreading.demo4;

public class Account {

    private long balance;

    public Account() {
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public synchronized long getBalance() {
        return balance;
    }

    public  void deposit(long amount) {
        checkAmountNonNegative(amount);
        synchronized (this) {
            balance += amount;
            notifyAll();
        }
    }

    public synchronized void withdraw(long amount) {
        checkAmountNonNegative(amount);
        if (balance < amount) {
            throw new IllegalArgumentException("not enough money");
        }
        balance -= amount;
    }

    public void waitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        synchronized (this){
            while (balance < amount) {
                wait();
            }
        }
        balance -= amount;
    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
