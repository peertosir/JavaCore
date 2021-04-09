package com.peertosir.javacore.chapter11;

public class NewThreadDemo {
    public static void main(String[] args) {
        new NewThread();
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

class NewThread implements Runnable {

    Thread t;

    public NewThread() {
        t = new Thread(this, "Demo thread");
        System.out.println("Child thread created");
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Child thread finished");
    }
}