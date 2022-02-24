package ru.csc.java2014.multithreading.demo3;

import java.util.concurrent.atomic.LongAdder;

public class Account {

  private final LongAdder adder;
//  private final AtomicLong balance;

//  public Account() {
//    this(new AtomicLong(0));
//  }

//    public Account() {
//    this(0);
//  }
//
//  public Account(AtomicLong balance) {
//    this.balance = balance;
//  }
//
//  public AtomicLong getBalance() {
//    return balance;
//  }
//
//  public void deposit(long amount) {
//    checkAmountNonNegative(amount);
//    balance.getAndAdd(amount);
//  }
//
//  public void withdraw(long amount) {
//    checkAmountNonNegative(amount);
//    if (balance.get() < amount) {
//      throw new IllegalArgumentException("not enough money");
//    }
//    balance.getAndAdd(-amount);
//  }
//
//  private static void checkAmountNonNegative(long amount) {
//    if (amount < 0) {
//      throw new IllegalArgumentException("negative amount");
//    }
//  }

  public Account(long balance) {
    adder = new LongAdder();
    adder.add(balance);
  }

  public long getBalance() {
    return adder.longValue();
  }

  public void deposit(int amount) {
    checkAmountNonNegative(amount);
    adder.add(amount);
    adder.sum();

  }

  public void withdraw(int amount) {
    checkAmountNonNegative(amount);
    if (adder.longValue() < amount) {
      throw new IllegalArgumentException("not enough money");
    }
    adder.add(-amount);
    adder.sum();
  }

  private static void checkAmountNonNegative(long amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("negative amount");
    }
  }
}
