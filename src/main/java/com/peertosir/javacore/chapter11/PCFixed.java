package com.peertosir.javacore.chapter11;

public class PCFixed {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("Press ctrl/cmnd+C to exit...");
    }
}

class Q {
    int n;
    boolean valueSet  = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Catched interrupted exception");
            }
        }
        System.out.println("Get: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Catched interrupted exception");
            }
        }
        System.out.println("Put: " + n);
        this.n = n;
        valueSet = true;
        notify();
    }
}

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}
