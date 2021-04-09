package com.peertosir.javacore.chapter11;

class ExtendThread extends Thread {
    public ExtendThread() {
        super("Demo thread");
        System.out.println("Child thread");
        this.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Child thread finished");
    }
}

public class ExtendThreadDemo {
    public static void main(String[] args) {
        new ExtendThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread finished");
    }
}