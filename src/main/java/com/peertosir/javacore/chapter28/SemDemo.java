package com.peertosir.javacore.chapter28;

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new IncThread("A", sem);
        new DecThread("B", sem);

    }
}

class Shared {
    static int count = 0;
}


class IncThread implements Runnable {

    String name;
    Semaphore semaphore;

    public IncThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Running thread: " + name);
        try {
            System.out.println("Thread " + name + " waiting for permission");
            semaphore.acquire();
            System.out.println("Thread " + name + " got permission");
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        System.out.println("Thread " + name + " release permission");
        semaphore.release();
    }
}

class DecThread implements Runnable {

    String name;
    Semaphore semaphore;

    public DecThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Running thread: " + name);
        try {
            System.out.println("Thread " + name + " waiting for permission");
            semaphore.acquire();
            System.out.println("Thread " + name + " got permission");
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        System.out.println("Thread " + name + " release permission");
        semaphore.release();
    }
}