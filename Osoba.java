package com.company;

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
}
