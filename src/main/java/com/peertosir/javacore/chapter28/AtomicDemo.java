package com.peertosir.javacore.chapter28;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        new AtomThread("a");
        new AtomThread("b");
        new AtomThread("c");

    }
}

class Shared2 {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomThread implements Runnable {
    String name;

    public AtomThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting thread " + name);
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread " + name + " got: " + Shared2.ai.getAndSet(i));
        }
    }
}
