package ru.csc.java2014.multithreading.demo3;

import java.util.concurrent.atomic.AtomicLong;

public class Account {

  //    private /*volatile*/ long balance;
  private final AtomicLong balance;

  public Account() {
    this(new AtomicLong(0));
  }

  public Account(AtomicLong balance) {
    this.balance = balance;
  }

  public AtomicLong getBalance() {
    return balance;
  }

  public void deposit(long amount) {
    checkAmountNonNegative(amount);
    balance.getAndAdd(amount);
  }

  public void withdraw(long amount) {
    checkAmountNonNegative(amount);
    if (balance.get() < amount) {
      throw new IllegalArgumentException("not enough money");
    }
    balance.getAndAdd(-amount);
  }

  private static void checkAmountNonNegative(long amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("negative amount");
    }
  }
}
