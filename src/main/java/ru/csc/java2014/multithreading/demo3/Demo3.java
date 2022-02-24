package ru.csc.java2014.multithreading.demo3;

import java.util.concurrent.atomic.AtomicLong;

public class Demo3 {

  public static void main(String[] args) throws Exception {
    Account account = new Account(new AtomicLong(100000));
    System.out.println("Begin balance = " + account.getBalance());

    Runnable r1 = () -> { // anonymous class
        for (int i = 0; i < 20000; ++i) {
          account.withdraw(1);
        }
    };

    Runnable r2 = () -> { // anonymous class
        for (int i = 0; i < 20000; ++i) {
          account.deposit(1);
        }
    };

    Thread withdrawThread = new Thread(r1);
    Thread depositThread = new Thread(r2);
    withdrawThread.start();
    depositThread.start();

    withdrawThread.join();
    depositThread.join();

    System.out.println("End balance = " + account.getBalance());
  }
}
