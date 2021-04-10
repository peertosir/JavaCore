package com.peertosir.javacore.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Launching threads...");
        new Thread1(cb, "one");
        new Thread1(cb, "two");
        new Thread1(cb, "three");
    }
}

class Thread1 implements Runnable {

    CyclicBarrier cb;
    String name;

    public Thread1(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cb.await();
        } catch (BrokenBarrierException | InterruptedException exception) {
            System.out.println(exception);
        }
    }
}

class BarAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Barrier reached");
    }
}