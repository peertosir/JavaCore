package com.peertosir.javacore.chapter28;

import java.util.concurrent.Semaphore;

public class ProdConSemaphoreDemo {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}

class Q {
    int n;

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
        System.out.println("Got: " + n);
        semProd.release();
    }

    void put(int i) {
        try {
            semProd.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
        System.out.println("Put: " + i);
        n = i;
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.put(i);
        }
    }
}

class Consumer implements Runnable {

    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.get();
        }
    }
}
