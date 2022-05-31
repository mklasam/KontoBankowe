# KontoBankowe

- Program for checking the bank balance


# Introduction
- Program is very usefull as a bank balance checker,
- It can be useful on a daily basis,
- It might be attractive especiallly for students or any bank account holders.

# Technology
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)


# Setup
- To run this project all you have to do is to install the Intellij and then copy the codes below.


# Codes

    public class KontoBankowe {
    private int saldo;
    public KontoBankowe(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void wyplac(int kwota) {
        saldo -= kwota;
    }
    
<br>

    public class Main {
    public static void main(String[] args) {
        KontoBankowe account = new KontoBankowe(150);
        Thread t1= new Thread(new Osoba(account), "T1");
        Thread t2 = new Thread(new Osoba(account), "T2");
        t1.start();
        t2.start();
    }
    }
    
  <br>
  
    import java.util.Random;

    public class Osoba implements Runnable {
    private final KontoBankowe konto;
    private final Random los;

    public Osoba(KontoBankowe konto) {
        los = new Random();
        this.konto = konto;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (konto) {
                int kwota = los.nextInt(100);

                if (konto.getSaldo() < kwota) {
                    System.out.printf("%s koniec saldo=%d, kwota=%d\n", Thread.currentThread().getName(),
                            konto.getSaldo(), kwota);
                    break;
                }

                System.out.printf("%s wypłaca saldo=%d, kwota=%d\n", Thread.currentThread().getName(),
                        konto.getSaldo(), kwota);

                konto.wyplac(kwota);

                System.out.printf("%s zakończono wypłacanie saldo=%d\n", Thread.currentThread().getName(),
                        konto.getSaldo());

                if (konto.getSaldo() < 0) {
                    System.out.printf("%s NOPE saldo=%d, kwota=%d\n", Thread.currentThread().getName(),
                            konto.getSaldo(), kwota);
                    break;
                }

            }
        }
    }
 

