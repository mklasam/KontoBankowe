package com.company;

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
}
