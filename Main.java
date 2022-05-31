package com.company;

public class Main {
    public static void main(String[] args) {
        KontoBankowe account = new KontoBankowe(150);
        Thread t1= new Thread(new Osoba(account), "T1");
        Thread t2 = new Thread(new Osoba(account), "T2");
        t1.start();
        t2.start();
    }
}

