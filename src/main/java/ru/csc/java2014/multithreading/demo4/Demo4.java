package ru.csc.java2014.multithreading.demo4;

public class Demo4 {

  public static void main(String[] args) throws Exception {
    Account account = new Account(0);

    Runnable r = () -> {
      for (int i = 0; i < 60000000; ++i) {
        account.deposit(1);
      }
    };

    new Thread(r).start();

    account.waitAndWithdraw(50000000);

    System.out.println("waitAndWithdraw finished, end balance = " + account.getBalance());
  }
}
